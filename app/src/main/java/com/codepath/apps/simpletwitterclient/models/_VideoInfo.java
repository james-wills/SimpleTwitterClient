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
 * Automatically generated Parcelable implementation for _VideoInfo.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _VideoInfo's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _VideoInfo implements Parcelable {

  protected List<Integer> mAspectRatio;
  protected List<VideoVariant> mVariants;
  protected long mDurationMillis;

  protected _VideoInfo(List<Integer> aspectRatio, List<VideoVariant> variants, long durationMillis) {
    this();
    mAspectRatio = aspectRatio;
    mVariants = variants;
    mDurationMillis = durationMillis;
  }

  protected _VideoInfo() {
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

    _VideoInfo that = (_VideoInfo) object;

    return new EqualsBuilder()
        .append(this.mAspectRatio, that.mAspectRatio)
        .append(this.mVariants, that.mVariants)
        .append(this.mDurationMillis, that.mDurationMillis)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mAspectRatio)
        .append(mVariants)
        .append(mDurationMillis)
        .toHashCode();
  }

  public List<Integer> getAspectRatio() {
    return mAspectRatio;
  }

  public List<VideoVariant> getVariants() {
    return mVariants;
  }

  public long getDurationMillis() {
    return mDurationMillis;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeList(mAspectRatio);
    parcel.writeList(mVariants);
    parcel.writeLong(mDurationMillis);
  }

  public void readFromParcel(Parcel source) {
    mAspectRatio = source.readArrayList(Integer.class.getClassLoader());
    mVariants = source.readArrayList(VideoVariant.class.getClassLoader());
    mDurationMillis = source.readLong();
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("aspect_ratio")) {
      mAspectRatio = JsonUtil.parseIntegerJsonList(json.optJSONArray("aspect_ratio"));
    } else {
      mAspectRatio = java.util.Collections.emptyList();
    }
    if (!json.isNull("variants")) {
      mVariants = JsonUtil.parseJsonList(json.optJSONArray("variants"), VideoVariant.CREATOR);
    } else {
      mVariants = java.util.Collections.emptyList();
    }
    if (!json.isNull("duration_millis")) {
      mDurationMillis = json.optLong("duration_millis");
    } else {
      mDurationMillis = -1;
    }
  }

}
