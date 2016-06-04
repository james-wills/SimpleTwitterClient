package com.codepath.apps.simpletwitterclient.models;

import android.util.Log;

import com.codepath.apps.simpletwitterclient.utils.JsonHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/2/16.
 */
public class DetailUser extends User {
  RichText description;
  RichText url;
  String location;
  String bannerImageUrl;
  long followerCount;
  long friendsCount;
  boolean isFollowing;
  boolean isProtected;
  boolean isVerified;

  public boolean isVerified() {
    return isVerified;
  }

  public RichText getDescription() {
    return description;
  }

  public String getLocation() {
    return location;
  }

  public String getBannerImageUrl() {
    return bannerImageUrl;
  }

  public long getFollowerCount() {
    return followerCount;
  }

  public long getFriendsCount() {
    return friendsCount;
  }

  public boolean isFollowing() {
    return isFollowing;
  }

  public boolean isProtected() {
    return isProtected;
  }

  public RichText getUrl() {
    return url;
  }

  public DetailUser(JSONObject json) {
    super(json);

    try {
      this.bannerImageUrl = JsonHelper.getString(json, "profile_banner_url");
      this.location = JsonHelper.getString(json, "location");
      this.followerCount = JsonHelper.getLong(json, "followers_count");
      this.friendsCount = JsonHelper.getLong(json, "friends_count");
      this.isFollowing = JsonHelper.getBoolean(json, "following");
      this.isProtected = JsonHelper.getBoolean(json, "protected");
      this.isVerified = JsonHelper.getBoolean(json, "verified");

      String descriptionText = JsonHelper.getString(json, "description");
      JSONObject entities = json.getJSONObject("entities");
      JSONObject descriptionEntities = entities.getJSONObject("description");
      List<TextUrl> descriptionUrls = TextUrl.fromJsonArray(descriptionEntities.getJSONArray("urls"));
      description = new RichText(descriptionText, descriptionUrls);
      if (entities.has("url")) {
        List<TextUrl> urls = TextUrl.fromJsonArray(entities.getJSONObject("url").getJSONArray("urls"));
        if (urls.size() == 1) {
          TextUrl u = urls.get(0);
          Log.d("JB", u.toString());
          url = new RichText(u.getUrl(), urls);
        }
      } else {
        url = new RichText();
      }
    } catch (JSONException e) {
      try {
        Log.d("DEBUG DETAIL USER", json.toString(2));
      } catch (JSONException e2) {
        e2.printStackTrace();
      }
      e.printStackTrace();
    }
  }

  public boolean hasUrl() {
    return !url.getBaseText().equals("");
  }

  public boolean hasDescription() {
    return !description.getBaseText().equals("");
  }

  public boolean hasLocation() {
    return !location.equals("");
  }

  @Override
  public String toString() {
    String s = "";
    s += "description: " + description;
    s += "\nlocation: " + location;
    s += "\nurl: " + url;
    s += "\nbannerImageUrl: " + bannerImageUrl;
    s += "\nfollowerCount: " + followerCount;
    s += "\nfriendCount: " + friendsCount;
    return s;
  }
}
