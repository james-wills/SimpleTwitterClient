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
 * Automatically generated Parcelable implementation for _UrlEntity.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _UrlEntity's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _UrlEntity implements Parcelable {

  protected List<Integer> mIndices;
  protected String mUrl;
  protected String mDisplayUrl;
  protected String mExpandedUrl;

  protected _UrlEntity(List<Integer> indices, String url, String displayUrl, String expandedUrl) {
    this();
    mIndices = indices;
    mUrl = url;
    mDisplayUrl = displayUrl;
    mExpandedUrl = expandedUrl;
  }

  protected _UrlEntity() {
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

    _UrlEntity that = (_UrlEntity) object;

    return new EqualsBuilder()
        .append(this.mIndices, that.mIndices)
        .append(this.mUrl, that.mUrl)
        .append(this.mDisplayUrl, that.mDisplayUrl)
        .append(this.mExpandedUrl, that.mExpandedUrl)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mIndices)
        .append(mUrl)
        .append(mDisplayUrl)
        .append(mExpandedUrl)
        .toHashCode();
  }

  public List<Integer> getIndices() {
    return mIndices;
  }

  public String getUrl() {
    return mUrl;
  }

  public String getDisplayUrl() {
    return mDisplayUrl;
  }

  public String getExpandedUrl() {
    return mExpandedUrl;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeList(mIndices);
    parcel.writeValue(mUrl);
    parcel.writeValue(mDisplayUrl);
    parcel.writeValue(mExpandedUrl);
  }

  public void readFromParcel(Parcel source) {
    mIndices = source.readArrayList(Integer.class.getClassLoader());
    mUrl = (String) source.readValue(String.class.getClassLoader());
    mDisplayUrl = (String) source.readValue(String.class.getClassLoader());
    mExpandedUrl = (String) source.readValue(String.class.getClassLoader());
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("indices")) {
      mIndices = JsonUtil.parseIntegerJsonList(json.optJSONArray("indices"));
    } else {
      mIndices = java.util.Collections.emptyList();
    }
    if (!json.isNull("url")) {
      mUrl = json.optString("url");
    }
    if (!json.isNull("display_url")) {
      mDisplayUrl = json.optString("display_url");
    }
    if (!json.isNull("expanded_url")) {
      mExpandedUrl = json.optString("expanded_url");
    }
  }

}
