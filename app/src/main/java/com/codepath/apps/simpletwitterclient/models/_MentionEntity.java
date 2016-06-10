package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonUtil;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Automatically generated Parcelable implementation for _MentionEntity.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _MentionEntity's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _MentionEntity implements Parcelable {

  protected List<Integer> mIndices;
  protected String mScreenName;
  protected String mName;
  protected String mIdStr;
  protected long mId;

  protected _MentionEntity(List<Integer> indices, String screenName, String name, String idStr, long id) {
    this();
    mIndices = indices;
    mScreenName = screenName;
    mName = name;
    mIdStr = idStr;
    mId = id;
  }

  protected _MentionEntity() {
    super();
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) {
      return false;
    }

    if (object == this) {
      return true;
    }

    if (object.getClass() != getClass()) {
      return false;
    }

    _MentionEntity that = (_MentionEntity) object;

    return new EqualsBuilder()
        .append(this.mIndices, that.mIndices)
        .append(this.mScreenName, that.mScreenName)
        .append(this.mName, that.mName)
        .append(this.mIdStr, that.mIdStr)
        .append(this.mId, that.mId)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mIndices)
        .append(mScreenName)
        .append(mName)
        .append(mIdStr)
        .append(mId)
        .toHashCode();
  }

  public List<Integer> getIndices() {
    return mIndices;
  }

  public String getScreenName() {
    return mScreenName;
  }

  public String getName() {
    return mName;
  }

  public String getIdStr() {
    return mIdStr;
  }

  public long getId() {
    return mId;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeList(mIndices);
    parcel.writeValue(mScreenName);
    parcel.writeValue(mName);
    parcel.writeValue(mIdStr);
    parcel.writeLong(mId);
  }

  public void readFromParcel(Parcel source) {
    mIndices = source.readArrayList(Integer.class.getClassLoader());
    mScreenName = (String) source.readValue(String.class.getClassLoader());
    mName = (String) source.readValue(String.class.getClassLoader());
    mIdStr = (String) source.readValue(String.class.getClassLoader());
    mId = source.readLong();
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("indices")) {
      mIndices = JsonUtil.parseIntegerJsonList(json.optJSONArray("indices"));
    } else {
      mIndices = java.util.Collections.emptyList();
    }
    if (!json.isNull("screen_name")) {
      mScreenName = json.optString("screen_name");
    }
    if (!json.isNull("name")) {
      mName = json.optString("name");
    }
    if (!json.isNull("id_str")) {
      mIdStr = json.optString("id_str");
    }
    mId = json.optLong("id");
  }

}
