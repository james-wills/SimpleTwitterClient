package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class UserEntities extends _UserEntities implements PrintUtils.Printable {

  public static final DualCreator<UserEntities> CREATOR = new DualCreator<UserEntities>() {

    public UserEntities[] newArray(int size) {
      return new UserEntities[size];
    }

    public UserEntities createFromParcel(Parcel source) {
      UserEntities object = new UserEntities();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public UserEntities parse(JSONObject obj) throws JSONException {
      UserEntities newInstance = new UserEntities();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "url",
        "description"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        PrintUtils.toString(getUrl(), ""),
        PrintUtils.toString(getDescription(), "")
    };

    return values;
  }
}
