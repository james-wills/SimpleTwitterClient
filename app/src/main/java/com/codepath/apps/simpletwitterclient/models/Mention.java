package com.codepath.apps.simpletwitterclient.models;

import android.util.Log;

import com.codepath.apps.simpletwitterclient.utils.JsonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/2/16.
 */
public class Mention extends Link {
  String screenName;

  public Mention(JSONObject json) throws JSONException {
    super(json.getJSONArray("indices"));
    screenName = JsonHelper.getString(json, "screen_name");
  }

  public static List<Mention> fromJsonArray(JSONArray arr) {
    List<Mention> hashtags = new ArrayList<>();
    for (int i = 0; i < arr.length(); i++) {
      try {
        Mention hashtag = new Mention(arr.getJSONObject(i));
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
    return screenName;
  }

  @Override
  public String getDisplayLink() {
    return String.format("@%s", screenName);
  }

  @Override
  public String toString() {
    return "Screename: " + screenName + "\n" + super.toString();
  }
}
