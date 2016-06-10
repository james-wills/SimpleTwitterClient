package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Automatically generated Parcelable implementation for _VideoVariant.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _VideoVariant's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _VideoVariant implements Parcelable {

  protected String mContentType;
  protected String mUrl;
  protected int mBitrate;

  protected _VideoVariant(String contentType, String url, int bitrate) {
    this();
    mContentType = contentType;
    mUrl = url;
    mBitrate = bitrate;
  }

  protected _VideoVariant() {
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

    _VideoVariant that = (_VideoVariant) object;

    return new EqualsBuilder()
        .append(this.mContentType, that.mContentType)
        .append(this.mUrl, that.mUrl)
        .append(this.mBitrate, that.mBitrate)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mContentType)
        .append(mUrl)
        .append(mBitrate)
        .toHashCode();
  }

  public String getContentType() {
    return mContentType;
  }

  public String getUrl() {
    return mUrl;
  }

  public int getBitrate() {
    return mBitrate;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeValue(mContentType);
    parcel.writeValue(mUrl);
    parcel.writeInt(mBitrate);
  }

  public void readFromParcel(Parcel source) {
    mContentType = (String) source.readValue(String.class.getClassLoader());
    mUrl = (String) source.readValue(String.class.getClassLoader());
    mBitrate = source.readInt();
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("content_type")) {
      mContentType = json.optString("content_type");
    }
    if (!json.isNull("url")) {
      mUrl = json.optString("url");
    }
    if (!json.isNull("bitrate")) {
      mBitrate = json.optInt("bitrate");
    } else {
      mBitrate = -1;
    }
  }

}
