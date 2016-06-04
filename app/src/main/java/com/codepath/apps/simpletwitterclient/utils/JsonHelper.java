package com.codepath.apps.simpletwitterclient.utils;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by james_wills on 6/3/16.
 */
public class JsonHelper {

  public static String getString(JSONObject j, String key) throws JSONException {
    return (String) getObject(j, key, "");
  }

  public static long getLong(JSONObject j, String key) throws JSONException {
    if (j.has(key) && !j.isNull(key)) {
      return j.getLong(key);
    } else {
      return -1L;
    }
  }

  public static int getInt(JSONObject j, String key) throws JSONException {
    if (j.has(key) && !j.isNull(key)) {
      return j.getInt(key);
    } else {
      return -1;
    }
  }

  public static boolean getBoolean(JSONObject j, String key) throws JSONException {
    return (boolean) getObject(j, key, false);
  }

  public static Object getObject(JSONObject j, String key, Object defaultVal) throws JSONException {
    if (j.has(key) && !j.isNull(key)) {
      return j.get(key);
    } else {
      return defaultVal;
    }
  }
}
