package com.codepath.apps.simpletwitterclient.models;

import com.activeandroid.util.Log;
import com.codepath.apps.simpletwitterclient.utils.JsonHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/2/16.
 */
public class MediaLink extends TextUrl {
  String type;
  int width;
  int height;
  long id;
  String mediaUrl;

  public MediaLink(JSONObject json) throws JSONException {
    super(json);
    JSONObject largeSizes = json.getJSONObject("sizes").getJSONObject("large");
    width = JsonHelper.getInt(largeSizes, "w");
    height = JsonHelper.getInt(json, "h");
    type = JsonHelper.getString(json, "type");
    id = JsonHelper.getLong(json, "id");
    mediaUrl = JsonHelper.getString(json, "media_url");
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public String getType() {
    return type;
  }

  public String getMediaUrl() {
    return mediaUrl;
  }

  public static List<MediaLink> mediaFromJsonArray(JSONArray arr) {
    List<MediaLink> media = new ArrayList<>();
    for (int i = 0; i < arr.length(); i++) {
      try {
        MediaLink image = new MediaLink(arr.getJSONObject(i));
        media.add(image);
      } catch(JSONException e) {
        e.printStackTrace();
        continue;
      }
    }

    try {
      Log.d("JBDEBUG", arr.toString(2));
    } catch (JSONException e) {

    }
    return media;
  }

  @Override
  public String toString() {
    String s = "";

    s += "type: " + type + "\n";
    s += "width: " + width + "\n";
    s += "height: " + height + "\n";
    s += "id: " + id + "\n";
    s += "mediaUrl: " + mediaUrl + "\n";
    return super.toString();
  }
}
