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
 * Automatically generated Parcelable implementation for _MediaEntity.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _MediaEntity's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _MediaEntity implements Parcelable {

  protected AdditionalMediaInfo mAdditionalMediaInfo;
  protected List<Integer> mIndices;
  protected MediaSizeOptions mSizes;
  protected String mIdStr;
  protected String mMediaUrl;
  protected String mMediaUrlHttps;
  protected String mUrl;
  protected String mDisplayUrl;
  protected String mExpandedUrl;
  protected String mSourceStatusIdStr;
  protected String mSourceUserIdStr;
  protected String mType;
  protected boolean mTruncated;
  protected boolean mIsQuoteStatus;
  protected boolean mFavorited;
  protected boolean mRetweeted;
  protected long mId;
  protected long mSourceStatusId;
  protected long mSourceUserId;

  protected _MediaEntity(AdditionalMediaInfo additionalMediaInfo, List<Integer> indices, MediaSizeOptions sizes, String idStr, String mediaUrl, String mediaUrlHttps, String url, String displayUrl, String expandedUrl, String sourceStatusIdStr, String sourceUserIdStr, String type, boolean truncated, boolean isQuoteStatus, boolean favorited, boolean retweeted, long id, long sourceStatusId, long sourceUserId) {
    this();
    mAdditionalMediaInfo = additionalMediaInfo;
    mIndices = indices;
    mSizes = sizes;
    mIdStr = idStr;
    mMediaUrl = mediaUrl;
    mMediaUrlHttps = mediaUrlHttps;
    mUrl = url;
    mDisplayUrl = displayUrl;
    mExpandedUrl = expandedUrl;
    mSourceStatusIdStr = sourceStatusIdStr;
    mSourceUserIdStr = sourceUserIdStr;
    mType = type;
    mTruncated = truncated;
    mIsQuoteStatus = isQuoteStatus;
    mFavorited = favorited;
    mRetweeted = retweeted;
    mId = id;
    mSourceStatusId = sourceStatusId;
    mSourceUserId = sourceUserId;
  }

  protected _MediaEntity() {
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

    _MediaEntity that = (_MediaEntity) object;

    return new EqualsBuilder()
        .append(this.mAdditionalMediaInfo, that.mAdditionalMediaInfo)
        .append(this.mIndices, that.mIndices)
        .append(this.mSizes, that.mSizes)
        .append(this.mIdStr, that.mIdStr)
        .append(this.mMediaUrl, that.mMediaUrl)
        .append(this.mMediaUrlHttps, that.mMediaUrlHttps)
        .append(this.mUrl, that.mUrl)
        .append(this.mDisplayUrl, that.mDisplayUrl)
        .append(this.mExpandedUrl, that.mExpandedUrl)
        .append(this.mSourceStatusIdStr, that.mSourceStatusIdStr)
        .append(this.mSourceUserIdStr, that.mSourceUserIdStr)
        .append(this.mType, that.mType)
        .append(this.mTruncated, that.mTruncated)
        .append(this.mIsQuoteStatus, that.mIsQuoteStatus)
        .append(this.mFavorited, that.mFavorited)
        .append(this.mRetweeted, that.mRetweeted)
        .append(this.mId, that.mId)
        .append(this.mSourceStatusId, that.mSourceStatusId)
        .append(this.mSourceUserId, that.mSourceUserId)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mAdditionalMediaInfo)
        .append(mIndices)
        .append(mSizes)
        .append(mIdStr)
        .append(mMediaUrl)
        .append(mMediaUrlHttps)
        .append(mUrl)
        .append(mDisplayUrl)
        .append(mExpandedUrl)
        .append(mSourceStatusIdStr)
        .append(mSourceUserIdStr)
        .append(mType)
        .append(mTruncated)
        .append(mIsQuoteStatus)
        .append(mFavorited)
        .append(mRetweeted)
        .append(mId)
        .append(mSourceStatusId)
        .append(mSourceUserId)
        .toHashCode();
  }

  public AdditionalMediaInfo getAdditionalMediaInfo() {
    return mAdditionalMediaInfo;
  }

  public List<Integer> getIndices() {
    return mIndices;
  }

  public MediaSizeOptions getSizes() {
    return mSizes;
  }

  public String getIdStr() {
    return mIdStr;
  }

  public String getMediaUrl() {
    return mMediaUrl;
  }

  public String getMediaUrlHttps() {
    return mMediaUrlHttps;
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

  public String getSourceStatusIdStr() {
    return mSourceStatusIdStr;
  }

  public String getSourceUserIdStr() {
    return mSourceUserIdStr;
  }

  public String getType() {
    return mType;
  }

  public boolean getTruncated() {
    return mTruncated;
  }

  public boolean isQuoteStatus() {
    return mIsQuoteStatus;
  }

  public boolean getFavorited() {
    return mFavorited;
  }

  public boolean getRetweeted() {
    return mRetweeted;
  }

  public long getId() {
    return mId;
  }

  public long getSourceStatusId() {
    return mSourceStatusId;
  }

  public long getSourceUserId() {
    return mSourceUserId;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeParcelable(mAdditionalMediaInfo, 0);
    parcel.writeList(mIndices);
    parcel.writeParcelable(mSizes, 0);
    parcel.writeValue(mIdStr);
    parcel.writeValue(mMediaUrl);
    parcel.writeValue(mMediaUrlHttps);
    parcel.writeValue(mUrl);
    parcel.writeValue(mDisplayUrl);
    parcel.writeValue(mExpandedUrl);
    parcel.writeValue(mSourceStatusIdStr);
    parcel.writeValue(mSourceUserIdStr);
    parcel.writeValue(mType);
    parcel.writeBooleanArray(new boolean[]{mTruncated, mIsQuoteStatus, mFavorited, mRetweeted});
    parcel.writeLong(mId);
    parcel.writeLong(mSourceStatusId);
    parcel.writeLong(mSourceUserId);
  }

  public void readFromParcel(Parcel source) {
    mAdditionalMediaInfo = source.readParcelable(AdditionalMediaInfo.class.getClassLoader());
    mIndices = source.readArrayList(Integer.class.getClassLoader());
    mSizes = source.readParcelable(MediaSizeOptions.class.getClassLoader());
    mIdStr = (String) source.readValue(String.class.getClassLoader());
    mMediaUrl = (String) source.readValue(String.class.getClassLoader());
    mMediaUrlHttps = (String) source.readValue(String.class.getClassLoader());
    mUrl = (String) source.readValue(String.class.getClassLoader());
    mDisplayUrl = (String) source.readValue(String.class.getClassLoader());
    mExpandedUrl = (String) source.readValue(String.class.getClassLoader());
    mSourceStatusIdStr = (String) source.readValue(String.class.getClassLoader());
    mSourceUserIdStr = (String) source.readValue(String.class.getClassLoader());
    mType = (String) source.readValue(String.class.getClassLoader());
    boolean[] bools = source.createBooleanArray();
    mTruncated = bools[0];
    mIsQuoteStatus = bools[1];
    mFavorited = bools[2];
    mRetweeted = bools[3];
    mId = source.readLong();
    mSourceStatusId = source.readLong();
    mSourceUserId = source.readLong();
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("additional_media_info")) {
      mAdditionalMediaInfo = AdditionalMediaInfo.CREATOR.parse(json.getJSONObject("additional_media_info"));
    }
    if (!json.isNull("indices")) {
      mIndices = JsonUtil.parseIntegerJsonList(json.optJSONArray("indices"));
    } else {
      mIndices = java.util.Collections.emptyList();
    }
    if (!json.isNull("sizes")) {
      mSizes = MediaSizeOptions.CREATOR.parse(json.getJSONObject("sizes"));
    }
    if (!json.isNull("id_str")) {
      mIdStr = json.optString("id_str");
    }
    if (!json.isNull("media_url")) {
      mMediaUrl = json.optString("media_url");
    }
    if (!json.isNull("media_url_https")) {
      mMediaUrlHttps = json.optString("media_url_https");
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
    if (!json.isNull("source_status_id_str")) {
      mSourceStatusIdStr = json.optString("source_status_id_str");
    }
    if (!json.isNull("source_user_id_str")) {
      mSourceUserIdStr = json.optString("source_user_id_str");
    }
    if (!json.isNull("type")) {
      mType = json.optString("type");
    }
    mTruncated = json.optBoolean("truncated");
    mIsQuoteStatus = json.optBoolean("is_quote_status");
    mFavorited = json.optBoolean("favorited");
    mRetweeted = json.optBoolean("retweeted");
    if (!json.isNull("id")) {
      mId = json.optLong("id");
    } else {
      mId = -1;
    }
    if (!json.isNull("source_status_id")) {
      mSourceStatusId = json.optLong("source_status_id");
    } else {
      mSourceStatusId = -1;
    }
    if (!json.isNull("source_user_id")) {
      mSourceUserId = json.optLong("source_user_id");
    } else {
      mSourceUserId = -1;
    }
  }

}
