package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;


public class MediaEntity extends _MediaEntity implements Entity, PrintUtils.Printable {

  public static final DualCreator<MediaEntity> CREATOR = new DualCreator<MediaEntity>() {

    public MediaEntity[] newArray(int size) {
      return new MediaEntity[size];
    }

    public MediaEntity createFromParcel(Parcel source) {
      MediaEntity object = new MediaEntity();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public MediaEntity parse(JSONObject obj) throws JSONException {
      MediaEntity newInstance = new MediaEntity();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  @Override
  public String getLink() {
    return getMediaUrl();
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

  public long getWidth() {
    return getSizes().getLarge().getW();
  }

  public long getHeight() {
    return getSizes().getLarge().getH();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "idStr",
        "mediaUrl",
        "mediaUrlHttps",
        "url",
        "displayUrl",
        "expandedUrl",
        "sourceStatusIdStr",
        "sourceUserIdStr",
        "type",
        "id",
        "sourceStatusId",
        "sourceUserId",
        "truncated",
        "favorited",
        "retweeted",
        "indices",
        "sizes"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getIdStr(),
        getMediaUrl(),
        getMediaUrlHttps(),
        getUrl(),
        getDisplayUrl(),
        getExpandedUrl(),
        getSourceStatusIdStr(),
        getSourceUserIdStr(),
        getType(),
        getId() + "",
        getSourceStatusId() + "",
        getSourceUserId() + "",
        getTruncated() + "",
        getFavorited() + "",
        getRetweeted() + "",
        PrintUtils.collectionString(getIndices()),
        PrintUtils.toString(getSizes(), "")
    };

    return values;
  }
}
