package com.codepath.apps.simpletwitterclient.models;


import com.codepath.apps.simpletwitterclient.utils.JsonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/2/16.
 */
public class Hashtag extends Link {
  String text;

  public Hashtag(JSONObject json) throws JSONException {
    super(json.getJSONArray("indices"));
    text = JsonHelper.getString(json, "text");
  }

  public static List<Hashtag> fromJsonArray(JSONArray arr) {
    List<Hashtag> hashtags = new ArrayList<>();
    for (int i = 0; i < arr.length(); i++) {
      try {
        Hashtag hashtag = new Hashtag(arr.getJSONObject(i));
        hashtags.add(hashtag);
      } catch(JSONException e) {
        e.printStackTrace();
        continue;
      }
    }

    return hashtags;
  }

  @Override
  public String getLink() {
    return text;
  }

  @Override
  public String getDisplayLink() {
    return text;
  }

  @Override
  public String toString() {
    return String.format("text: %s\n%s", text, super.toString());
  }
}
