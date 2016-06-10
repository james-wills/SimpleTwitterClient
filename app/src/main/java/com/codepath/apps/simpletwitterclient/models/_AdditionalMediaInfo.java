package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Automatically generated Parcelable implementation for _AdditionalMediaInfo.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _AdditionalMediaInfo's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _AdditionalMediaInfo implements Parcelable {

  protected User mSourceUser;
  protected boolean mMonetizable;

  protected _AdditionalMediaInfo(User sourceUser, boolean monetizable) {
    this();
    mSourceUser = sourceUser;
    mMonetizable = monetizable;
  }

  protected _AdditionalMediaInfo() {
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

    _AdditionalMediaInfo that = (_AdditionalMediaInfo) object;

    return new EqualsBuilder()
        .append(this.mSourceUser, that.mSourceUser)
        .append(this.mMonetizable, that.mMonetizable)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mSourceUser)
        .append(mMonetizable)
        .toHashCode();
  }

  public User getSourceUser() {
    return mSourceUser;
  }

  public boolean getMonetizable() {
    return mMonetizable;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeParcelable(mSourceUser, 0);
    parcel.writeBooleanArray(new boolean[]{mMonetizable});
  }

  public void readFromParcel(Parcel source) {
    mSourceUser = source.readParcelable(User.class.getClassLoader());
    boolean[] bools = source.createBooleanArray();
    mMonetizable = bools[0];
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("source_user")) {
      mSourceUser = User.CREATOR.parse(json.getJSONObject("source_user"));
    }
    mMonetizable = json.optBoolean("monetizable");
  }

}
