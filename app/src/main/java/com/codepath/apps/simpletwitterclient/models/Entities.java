package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;

import static com.codepath.apps.simpletwitterclient.utils.PrintUtils.collectionString;


public class Entities extends _Entities implements PrintUtils.Printable {

  public static final DualCreator<Entities> CREATOR = new DualCreator<Entities>() {

    public Entities[] newArray(int size) {
      return new Entities[size];
    }

    public Entities createFromParcel(Parcel source) {
      Entities object = new Entities();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public Entities parse(JSONObject obj) throws JSONException {
      Entities newInstance = new Entities();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "media",
        "hashtags",
        "urls",
        "symbols",
        "mentions"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        collectionString(getMedia()),
        collectionString(getHashtags()),
        collectionString(getUrls()),
        collectionString(getSymbols()),
        collectionString(getMentions()),
    };

    return values;
  }
}
