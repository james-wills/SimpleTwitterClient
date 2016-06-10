package com.codepath.apps.simpletwitterclient.utils;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

/**
 * Created by james_wills on 6/9/16.
 */
public class PrintUtils {
  public interface Printable {
    String[] getPrintKeys();
    String[] getPrintValues();
  }

  private static final String INDENT = "  ";

  public static String collectionString(List<?> c, String baseIndent) {
    if (c == null) { return indent("null\n", baseIndent); }
    if (c.size() == 0) { return indent("[]\n", baseIndent); }

    String result = indent("[\n", baseIndent);

    String childIndent = baseIndent + INDENT;

    for (Object o : c) {
      if (o instanceof Printable) {
        result += toString((Printable) o, childIndent);
      } else {
        result += indent(o.toString(), childIndent);
      }

      result = addNewLine(result);
    }

    result += indent("]", baseIndent);

    result = addNewLine(result);
    return result;
  }

  public static String collectionString(List<?> c) {
    return collectionString(c, "");
  }

  public static String toString(Printable p) {
    return toString(p, "");
  }

  public static String toString(Printable p, String baseIndent) {
    if (p == null) {
      return "null";
    }

    return objectToString(p.getPrintKeys(), p.getPrintValues(), baseIndent);
  }

  public static String objectToString(String[] labels, String[] values, String baseIndent) {
    if (labels.length != values.length) {
      return "ERROR: values.size() !+ labels.size()";
    }

    if (labels.length == 0) {
      return "{}";
    }

    String result = indent("{\n", baseIndent);
    result = addLines(result, Arrays.asList(labels), Arrays.asList(values), baseIndent + INDENT);
    result += indent("}", baseIndent);
    result = addNewLine(result);
    return result;
  }

  public static void log(String s) {
    Log.d("DEBUG", s);
  }

  public static void log(String key, String s) {
    Log.d(key, s);
  }

  public static String indent(String s, String indent) {
    String result = "";
    if (isMultiLine(s)) {
      List<String> stringList = Arrays.asList(s.split("\n"));
      for (String str: stringList) {
        result += indent + str;
        result = addNewLine(result);
      }
    } else {
      result = String.format("%s%s", indent, s);
    }

    return result;
  }

  public static String addLines(String baseString, List<String> labels, List<String> values, String baseIndent) {
    if (labels.size() != values.size()) {
      return "ERROR: values.size() !+ labels.size()";
    }

    String result = baseString;
    for (int i = 0; i < values.size(); i++) {
      result = addLine(result, label(labels.get(i), values.get(i)), baseIndent + INDENT);
    }

    return result;
  }

  public static String addLine(String s, String newLine, String indent) {
    String result = String.format("%s%s", s, indent(newLine, indent));
    result = addNewLine(result);

    return result;
  }

  public static String label(String label, String value) {
    return String.format("%s: %s", label, value);
  }

  public static boolean isMultiLine(String line) {
    return line.indexOf('\n') != -1;
  }

  public static String addNewLine(String s) {
    String result = s;
    if (!s.endsWith("\n")) {
      result += "\n";
    }

    return result;
  }
}
