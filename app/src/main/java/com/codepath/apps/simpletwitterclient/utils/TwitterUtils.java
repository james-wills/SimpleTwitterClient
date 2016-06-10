package com.codepath.apps.simpletwitterclient.utils;

/**
 * Created by james_wills on 6/9/16.
 */
public class TwitterUtils {

  public static String getDisplayScreenName(String screenName) {
    return String.format("@%s", screenName);
  }

  public static String getDisplayHashtag(String hashtagText) {
    return String.format("#%s", hashtagText);
  }

  public static String getHighQualityAviUrl(String aviUrl) {
    return aviUrl.replace("_normal", "");
  }
}
