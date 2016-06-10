package com.codepath.apps.simpletwitterclient.utils;

/**
 * Created by james_wills on 6/8/16.
 */
public class NumberUtils {
  public static long ONE_THOUSAND = 10^3;
  public static long ONE_MILLION = 10^6;
  public static long ONE_BILLION = 10^9;

  public static String getNumberString(long number) {
    if (number < 10*ONE_THOUSAND) {
      return Long.toString(number);
    } else if (number < ONE_MILLION) {
      return Long.toString(number / ONE_THOUSAND) + "K";
    } else if (number < ONE_BILLION) {
      return Long.toString(number / ONE_MILLION) + "M";
    } else {
      return Long.toString(number / ONE_BILLION) + "B";
    }
  }

  public static String getNumberString(int number) {
    return getNumberString((long) number);
  }
}
