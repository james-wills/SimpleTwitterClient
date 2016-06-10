package com.codepath.apps.simpletwitterclient.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/3/16.
 */
public class JsonHelper {
  public interface JsonObjectHandler<T> {
    T fromJson(JSONObject j);
  }

  public static String getString(JSONObject j, String key) throws JSONException {
    return (String) getObject(j, key, "");
  }

  public static long getLong(JSONObject j, String key) throws JSONException {
    return getLong(j, key, -1L);
  }

  public static long getLong(JSONObject j, String key, long defaultVal) throws JSONException {
    if (j.has(key) && !j.isNull(key)) {
      return j.getLong(key);
    } else {
      return defaultVal;
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

  public static JSONObject getJSONObject(JSONObject j, String key, Object defaultVal) throws JSONException {
    return (JSONObject) getObject(j, key, defaultVal);
  }

  public static JSONArray getJsonArray(JSONObject j, String key, Object defaultVal) throws JSONException {
    return (JSONArray) getObject(j, key, defaultVal);
  }

  public static Object getObject(JSONObject j, String key, Object defaultVal) throws JSONException {
    if (j.has(key) && !j.isNull(key)) {
      return j.get(key);
    } else {
      return defaultVal;
    }
  }

  public static <T> List<T> fromJSONArray(JSONArray arr, JsonObjectHandler<T> handler) {
    ArrayList<T> items = new ArrayList<>();
    for (int i = 0; i < arr.length(); i++) {
      try {
        T o = handler.fromJson(arr.getJSONObject(i));
        if (o != null) {
          items.add(o);
        }
      } catch (JSONException e) {
        e.printStackTrace();
        continue;
      }
    }

    return items;
  }
}
