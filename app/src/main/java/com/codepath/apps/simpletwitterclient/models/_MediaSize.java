package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Automatically generated Parcelable implementation for _MediaSize.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _MediaSize's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _MediaSize implements Parcelable {

  protected String mResize;
  protected int mH;
  protected int mW;

  protected _MediaSize(String resize, int h, int w) {
    this();
    mResize = resize;
    mH = h;
    mW = w;
  }

  protected _MediaSize() {
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

    _MediaSize that = (_MediaSize) object;

    return new EqualsBuilder()
        .append(this.mResize, that.mResize)
        .append(this.mH, that.mH)
        .append(this.mW, that.mW)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mResize)
        .append(mH)
        .append(mW)
        .toHashCode();
  }

  public String getResize() {
    return mResize;
  }

  public int getH() {
    return mH;
  }

  public int getW() {
    return mW;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeValue(mResize);
    parcel.writeInt(mH);
    parcel.writeInt(mW);
  }

  public void readFromParcel(Parcel source) {
    mResize = (String) source.readValue(String.class.getClassLoader());
    mH = source.readInt();
    mW = source.readInt();
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("resize")) {
      mResize = json.optString("resize");
    }
    mH = json.optInt("h");
    mW = json.optInt("w");
  }

}
