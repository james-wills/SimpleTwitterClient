package com.codepath.apps.simpletwitterclient.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by james_wills on 6/1/16.
 */
public class User {
  private String name;
  private long user_id;
  private String screenName;
  private String profileImageUrl;

  public String getName() {
    return name;
  }

  public long getUser_id() {
    return user_id;
  }

  public String getScreenName() {
    return String.format("@%s", screenName);
  }

  public String getProfileImageUrl() {
    return profileImageUrl;
  }



  public User(JSONObject json) {
    try {
      this.user_id = json.getLong("id");
      this.name = json.getString("name");
      this.screenName = json.getString("screen_name");
      this.profileImageUrl = getHighQualityURL(json.getString("profile_image_url"));
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public static User fromJSON(JSONObject json) {
    return new User(json);
  }

  private static String getHighQualityURL(String url) {
    return url.replace("_normal", "");
  }
}
