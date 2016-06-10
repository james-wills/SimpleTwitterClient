package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Automatically generated Parcelable implementation for _UserEntities.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _UserEntities's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _UserEntities implements Parcelable {

  protected Entities mUrl;
  protected Entities mDescription;

  protected _UserEntities(Entities url, Entities description) {
    this();
    mUrl = url;
    mDescription = description;
  }

  protected _UserEntities() {
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

    _UserEntities that = (_UserEntities) object;

    return new EqualsBuilder()
        .append(this.mUrl, that.mUrl)
        .append(this.mDescription, that.mDescription)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mUrl)
        .append(mDescription)
        .toHashCode();
  }

  public Entities getUrl() {
    return mUrl;
  }

  public Entities getDescription() {
    return mDescription;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeParcelable(mUrl, 0);
    parcel.writeParcelable(mDescription, 0);
  }

  public void readFromParcel(Parcel source) {
    mUrl = source.readParcelable(Entities.class.getClassLoader());
    mDescription = source.readParcelable(Entities.class.getClassLoader());
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("url")) {
      mUrl = Entities.CREATOR.parse(json.getJSONObject("url"));
    }
    if (!json.isNull("description")) {
      mDescription = Entities.CREATOR.parse(json.getJSONObject("description"));
    }
  }

}
