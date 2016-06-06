package com.codepath.apps.simpletwitterclient.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/2/16.
 */
public class TextUrl extends Link {
  String url;
  String displayUrl;
  String expandedUrl;

  public TextUrl(JSONObject json) throws JSONException {
    super(json.getJSONArray("indices"));
    url = json.getString("url");
    displayUrl = json.getString("display_url");
    expandedUrl = json.getString("expanded_url");
  }

  public String getUrl() {
    return url;
  }

  public String getDisplayUrl() {
    return displayUrl;
  }

  public String getExpandedUrl() {
    return expandedUrl;
  }

  public static List<TextUrl> fromJsonArray(JSONArray arr) {
    List<TextUrl> urls = new ArrayList<>();
    for (int i = 0; i < arr.length(); i++) {
      try {
        TextUrl url = new TextUrl(arr.getJSONObject(i));
        urls.add(url);
      } catch(JSONException e) {
        e.printStackTrace();
      }
    }

    return urls;
  }

  @Override
  public String toString() {
    return String.format("url: %s\ndisplayUrl: %s\nexpandedUrl: %s\n%s", url, displayUrl, expandedUrl, super.toString());
  }



  @Override
  public String getLink() {
    return url;
  }

  @Override
  public String getDisplayLink() {
    return displayUrl;
  }
}
