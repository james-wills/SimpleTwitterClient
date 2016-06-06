package com.codepath.apps.simpletwitterclient.utils;

import org.ocpsoft.prettytime.Duration;
import org.ocpsoft.prettytime.PrettyTime;
import org.ocpsoft.prettytime.TimeFormat;
import org.ocpsoft.prettytime.TimeUnit;
import org.ocpsoft.prettytime.units.Day;
import org.ocpsoft.prettytime.units.Hour;
import org.ocpsoft.prettytime.units.JustNow;
import org.ocpsoft.prettytime.units.Minute;
import org.ocpsoft.prettytime.units.Month;
import org.ocpsoft.prettytime.units.Second;
import org.ocpsoft.prettytime.units.Week;
import org.ocpsoft.prettytime.units.Year;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/4/16.
 */

public class TimeUtil {
  static PrettyTime p = null;
  public static PrettyTime getTimeFormatter() {
    if (p == null) {
      p = new PrettyTime();
    }

    PrettyTime p = new PrettyTime();
    p.clearUnits();

    p.registerUnit(new Second(), new SimpleTimeFormat("s"));
    p.registerUnit(new Minute(), new SimpleTimeFormat("m"));
    p.registerUnit(new Hour(), new SimpleTimeFormat("h"));
    p.registerUnit(new Day(), new SimpleTimeFormat("d"));
    p.registerUnit(new Week(), new SimpleTimeFormat("w"));
    p.registerUnit(new Month(), new SimpleTimeFormat("m"));
    p.registerUnit(new Year(), new SimpleTimeFormat("y"));

    return p;
  }

  public static SimpleDateFormat getTwitterApiDateFormat() {
    SimpleDateFormat s =  new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy");
    s.setLenient(true);
    return s;
  }

  public static class SimpleTimeFormat implements TimeFormat {
    String simpleTimeString;

    public SimpleTimeFormat(String simpleTimeString) {
      this.simpleTimeString = simpleTimeString;
    }

    @Override public String format(Duration duration) {
      return Math.abs(duration.getQuantity()) + simpleTimeString;
    }

    @Override public String formatUnrounded(Duration duration) { return format(duration); }
    @Override public String decorate(Duration duration, String time) { return time; }
    @Override public String decorateUnrounded(Duration duration, String time) { return time; }
  }
}

