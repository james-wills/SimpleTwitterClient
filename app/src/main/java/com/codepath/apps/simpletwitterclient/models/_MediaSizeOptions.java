package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Automatically generated Parcelable implementation for _MediaSizeOptions.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _MediaSizeOptions's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _MediaSizeOptions implements Parcelable {

  protected MediaSize mLarge;
  protected MediaSize mMedium;
  protected MediaSize mSmall;
  protected MediaSize mThumb;

  protected _MediaSizeOptions(MediaSize large, MediaSize medium, MediaSize small, MediaSize thumb) {
    this();
    mLarge = large;
    mMedium = medium;
    mSmall = small;
    mThumb = thumb;
  }

  protected _MediaSizeOptions() {
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

    _MediaSizeOptions that = (_MediaSizeOptions) object;

    return new EqualsBuilder()
        .append(this.mLarge, that.mLarge)
        .append(this.mMedium, that.mMedium)
        .append(this.mSmall, that.mSmall)
        .append(this.mThumb, that.mThumb)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mLarge)
        .append(mMedium)
        .append(mSmall)
        .append(mThumb)
        .toHashCode();
  }

  public MediaSize getLarge() {
    return mLarge;
  }

  public MediaSize getMedium() {
    return mMedium;
  }

  public MediaSize getSmall() {
    return mSmall;
  }

  public MediaSize getThumb() {
    return mThumb;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeParcelable(mLarge, 0);
    parcel.writeParcelable(mMedium, 0);
    parcel.writeParcelable(mSmall, 0);
    parcel.writeParcelable(mThumb, 0);
  }

  public void readFromParcel(Parcel source) {
    mLarge = source.readParcelable(MediaSize.class.getClassLoader());
    mMedium = source.readParcelable(MediaSize.class.getClassLoader());
    mSmall = source.readParcelable(MediaSize.class.getClassLoader());
    mThumb = source.readParcelable(MediaSize.class.getClassLoader());
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("large")) {
      mLarge = MediaSize.CREATOR.parse(json.getJSONObject("large"));
    }
    if (!json.isNull("medium")) {
      mMedium = MediaSize.CREATOR.parse(json.getJSONObject("medium"));
    }
    if (!json.isNull("small")) {
      mSmall = MediaSize.CREATOR.parse(json.getJSONObject("small"));
    }
    if (!json.isNull("thumb")) {
      mThumb = MediaSize.CREATOR.parse(json.getJSONObject("thumb"));
    }
  }

}
