package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class MediaSize extends _MediaSize implements PrintUtils.Printable {

  public static final DualCreator<MediaSize> CREATOR = new DualCreator<MediaSize>() {

    public MediaSize[] newArray(int size) {
      return new MediaSize[size];
    }

    public MediaSize createFromParcel(Parcel source) {
      MediaSize object = new MediaSize();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public MediaSize parse(JSONObject obj) throws JSONException {
      MediaSize newInstance = new MediaSize();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };


  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "h",
        "w",
        "resize",
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getH() + "",
        getW() + "",
        getResize()
    };

    return values;
  }

}
