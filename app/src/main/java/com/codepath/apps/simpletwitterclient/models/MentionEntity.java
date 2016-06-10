package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.TwitterUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class MentionEntity extends _MentionEntity implements Entity, PrintUtils.Printable {

  public static final DualCreator<MentionEntity> CREATOR = new DualCreator<MentionEntity>() {

    public MentionEntity[] newArray(int size) {
      return new MentionEntity[size];
    }

    public MentionEntity createFromParcel(Parcel source) {
      MentionEntity object = new MentionEntity();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public MentionEntity parse(JSONObject obj) throws JSONException {
      MentionEntity newInstance = new MentionEntity();
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
    return getDisplayMention(getScreenName());
  }

  @Override
  public int getStart() {
    return getIndices().get(0);
  }

  @Override
  public int getEnd() {
    return getIndices().get(1);
  }

  public static String getDisplayMention(String screenName) {
    return TwitterUtils.getDisplayScreenName(screenName);
  }

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "screenName",
        "name",
        "idStr",
        "indices"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getScreenName(),
        getName(),
        getIdStr(),
        PrintUtils.collectionString(getIndices())
    };

    return values;
  }
}
