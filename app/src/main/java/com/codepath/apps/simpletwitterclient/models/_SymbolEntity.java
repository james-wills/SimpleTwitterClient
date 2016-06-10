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
 * Automatically generated Parcelable implementation for _SymbolEntity.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _SymbolEntity's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _SymbolEntity implements Parcelable {

  protected List<Integer> mIndices;
  protected String mText;

  protected _SymbolEntity(List<Integer> indices, String text) {
    this();
    mIndices = indices;
    mText = text;
  }

  protected _SymbolEntity() {
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

    _SymbolEntity that = (_SymbolEntity) object;

    return new EqualsBuilder()
        .append(this.mIndices, that.mIndices)
        .append(this.mText, that.mText)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mIndices)
        .append(mText)
        .toHashCode();
  }

  public List<Integer> getIndices() {
    return mIndices;
  }

  public String getText() {
    return mText;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeList(mIndices);
    parcel.writeValue(mText);
  }

  public void readFromParcel(Parcel source) {
    mIndices = source.readArrayList(Integer.class.getClassLoader());
    mText = (String) source.readValue(String.class.getClassLoader());
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("indices")) {
      mIndices = JsonUtil.parseIntegerJsonList(json.optJSONArray("indices"));
    } else {
      mIndices = java.util.Collections.emptyList();
    }
    if (!json.isNull("text")) {
      mText = json.optString("text");
    }
  }

}
