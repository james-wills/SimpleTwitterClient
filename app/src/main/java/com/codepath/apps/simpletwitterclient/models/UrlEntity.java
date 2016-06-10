package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;

import static com.codepath.apps.simpletwitterclient.utils.PrintUtils.collectionString;


public class UrlEntity extends _UrlEntity implements Entity, PrintUtils.Printable {

  public static final DualCreator<UrlEntity> CREATOR = new DualCreator<UrlEntity>() {

    public UrlEntity[] newArray(int size) {
      return new UrlEntity[size];
    }

    public UrlEntity createFromParcel(Parcel source) {
      UrlEntity object = new UrlEntity();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public UrlEntity parse(JSONObject obj) throws JSONException {
      UrlEntity newInstance = new UrlEntity();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String getLink() {
    return getUrl();
  }

  @Override
  public String getDisplayLink() {
    return getDisplayUrl();
  }

  @Override
  public int getStart() {
    return getIndices().get(0);
  }

  @Override
  public int getEnd() {
    return getIndices().get(1);
  }

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "url",
        "displayUrl",
        "expandedUrl",
        "indices"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getUrl(),
        getDisplayUrl(),
        getExpandedUrl(),
        collectionString(getIndices())
    };

    return values;
  }
}
