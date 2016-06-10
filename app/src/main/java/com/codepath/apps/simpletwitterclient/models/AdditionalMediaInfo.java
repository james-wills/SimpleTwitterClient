package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class AdditionalMediaInfo extends _AdditionalMediaInfo implements PrintUtils.Printable {

  public static final DualCreator<AdditionalMediaInfo> CREATOR = new DualCreator<AdditionalMediaInfo>() {

    public AdditionalMediaInfo[] newArray(int size) {
      return new AdditionalMediaInfo[size];
    }

    public AdditionalMediaInfo createFromParcel(Parcel source) {
      AdditionalMediaInfo object = new AdditionalMediaInfo();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public AdditionalMediaInfo parse(JSONObject obj) throws JSONException {
      AdditionalMediaInfo newInstance = new AdditionalMediaInfo();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "monetizable",
        "sourceUser",
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getMonetizable() + "",
        PrintUtils.toString(getSourceUser(), ""),
    };

    return values;
  }
}
