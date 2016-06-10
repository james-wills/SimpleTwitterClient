package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class MediaSizeOptions extends _MediaSizeOptions implements PrintUtils.Printable {

  public static final DualCreator<MediaSizeOptions> CREATOR = new DualCreator<MediaSizeOptions>() {

    public MediaSizeOptions[] newArray(int size) {
      return new MediaSizeOptions[size];
    }

    public MediaSizeOptions createFromParcel(Parcel source) {
      MediaSizeOptions object = new MediaSizeOptions();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public MediaSizeOptions parse(JSONObject obj) throws JSONException {
      MediaSizeOptions newInstance = new MediaSizeOptions();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "small",
        "medium",
        "large",
        "thumb",
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        PrintUtils.toString(getSmall(), ""),
        PrintUtils.toString(getMedium(), ""),
        PrintUtils.toString(getLarge(), ""),
        PrintUtils.toString(getThumb(), "")
    };

    return values;
  }

}
