package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class VideoVariant extends _VideoVariant {

  public static final DualCreator<VideoVariant> CREATOR = new DualCreator<VideoVariant>() {

    public VideoVariant[] newArray(int size) {
      return new VideoVariant[size];
    }

    public VideoVariant createFromParcel(Parcel source) {
      VideoVariant object = new VideoVariant();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public VideoVariant parse(JSONObject obj) throws JSONException {
      VideoVariant newInstance = new VideoVariant();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

}
