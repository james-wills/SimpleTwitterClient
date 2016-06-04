package com.codepath.apps.simpletwitterclient.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;

/**
 * Created by james_wills on 6/2/16.
 */
public abstract class Link implements Comparable {
  int startIndex;
  int endIndex;

  public Link(JSONArray indices) throws JSONException {
    if (indices.length() == 2) {
      this.startIndex = indices.getInt(0);
      this.endIndex = indices.getInt(1);
    } else {
      Log.d("DEBUG", "More than  2 indices\n" + indices.toString(2));
    }
  }

  public int getStartIndex() {
    return startIndex;
  }

  public int getEndIndex() {
    return endIndex;
  }

  @Override
  public int compareTo(Object another) {
    if (another == null || !(another instanceof Link)) {
      return -1;
    }

    Link other = (Link) another;

    return this.startIndex - other.startIndex;
  }

  public abstract String getLink();
  public abstract String getDisplayLink();
}
