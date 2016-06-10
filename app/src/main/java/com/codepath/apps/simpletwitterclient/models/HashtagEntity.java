package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;

import static com.codepath.apps.simpletwitterclient.utils.PrintUtils.collectionString;


public class HashtagEntity extends _HashtagEntity implements Entity, PrintUtils.Printable {

  public static final DualCreator<HashtagEntity> CREATOR = new DualCreator<HashtagEntity>() {

    public HashtagEntity[] newArray(int size) {
      return new HashtagEntity[size];
    }

    public HashtagEntity createFromParcel(Parcel source) {
      HashtagEntity object = new HashtagEntity();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public HashtagEntity parse(JSONObject obj) throws JSONException {
      HashtagEntity newInstance = new HashtagEntity();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String getLink() {
    return "";
  }

  @Override
  public String getDisplayLink() {
    return getDisplayHashtag(getText());
  }

  @Override
  public int getStart() {
    return (int) getIndices().get(0);
  }

  @Override
  public int getEnd() {
    return (int) getIndices().get(1);
  }

  public static String getDisplayHashtag(String hashtagText) {
    return String.format("#%s", hashtagText);
  }

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "text",
        "indices"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getText(),
        collectionString(getIndices())
    };

    return values;
  }
}
