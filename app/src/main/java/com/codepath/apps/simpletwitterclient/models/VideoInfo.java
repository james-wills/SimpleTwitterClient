package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class VideoInfo extends _VideoInfo {

  public static final DualCreator<VideoInfo> CREATOR = new DualCreator<VideoInfo>() {

    public VideoInfo[] newArray(int size) {
      return new VideoInfo[size];
    }

    public VideoInfo createFromParcel(Parcel source) {
      VideoInfo object = new VideoInfo();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public VideoInfo parse(JSONObject obj) throws JSONException {
      VideoInfo newInstance = new VideoInfo();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

}
