package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Automatically generated Parcelable implementation for _Tweet.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _Tweet's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _Tweet implements Parcelable {

  protected Entities mEntities;
  protected Entities mExtended_entities;
  protected String mIdStr;
  protected String mCreatedAt;
  protected String mText;
  protected String mSource;
  protected String mInReplyToScreenName;
  protected String mInReplyToStatusIdStr;
  protected String mInReplyToUserIdStr;
  protected String mLang;
  protected Tweet mRetweetedStatus;
  protected User mUser;
  protected boolean mTruncated;
  protected boolean mIsQuoteStatus;
  protected boolean mFavorited;
  protected boolean mRetweeted;
  protected long mId;
  protected long mInReplyToStatusId;
  protected long mInReplyToUserId;
  protected long mFavoriteCount;
  protected long mRetweetCount;

  protected _Tweet(Entities entities, Entities extended_entities, String idStr, String createdAt, String text, String source, String inReplyToScreenName, String inReplyToStatusIdStr, String inReplyToUserIdStr, String lang, Tweet retweetedStatus, User user, boolean truncated, boolean isQuoteStatus, boolean favorited, boolean retweeted, long id, long inReplyToStatusId, long inReplyToUserId, long favoriteCount, long retweetCount) {
    this();
    mEntities = entities;
    mExtended_entities = extended_entities;
    mIdStr = idStr;
    mCreatedAt = createdAt;
    mText = text;
    mSource = source;
    mInReplyToScreenName = inReplyToScreenName;
    mInReplyToStatusIdStr = inReplyToStatusIdStr;
    mInReplyToUserIdStr = inReplyToUserIdStr;
    mLang = lang;
    mRetweetedStatus = retweetedStatus;
    mUser = user;
    mTruncated = truncated;
    mIsQuoteStatus = isQuoteStatus;
    mFavorited = favorited;
    mRetweeted = retweeted;
    mId = id;
    mInReplyToStatusId = inReplyToStatusId;
    mInReplyToUserId = inReplyToUserId;
    mFavoriteCount = favoriteCount;
    mRetweetCount = retweetCount;
  }

  protected _Tweet() {
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

    _Tweet that = (_Tweet) object;

    return new EqualsBuilder()
        .append(this.mEntities, that.mEntities)
        .append(this.mExtended_entities, that.mExtended_entities)
        .append(this.mIdStr, that.mIdStr)
        .append(this.mCreatedAt, that.mCreatedAt)
        .append(this.mText, that.mText)
        .append(this.mSource, that.mSource)
        .append(this.mInReplyToScreenName, that.mInReplyToScreenName)
        .append(this.mInReplyToStatusIdStr, that.mInReplyToStatusIdStr)
        .append(this.mInReplyToUserIdStr, that.mInReplyToUserIdStr)
        .append(this.mLang, that.mLang)
        .append(this.mRetweetedStatus, that.mRetweetedStatus)
        .append(this.mUser, that.mUser)
        .append(this.mTruncated, that.mTruncated)
        .append(this.mIsQuoteStatus, that.mIsQuoteStatus)
        .append(this.mFavorited, that.mFavorited)
        .append(this.mRetweeted, that.mRetweeted)
        .append(this.mId, that.mId)
        .append(this.mInReplyToStatusId, that.mInReplyToStatusId)
        .append(this.mInReplyToUserId, that.mInReplyToUserId)
        .append(this.mFavoriteCount, that.mFavoriteCount)
        .append(this.mRetweetCount, that.mRetweetCount)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mEntities)
        .append(mExtended_entities)
        .append(mIdStr)
        .append(mCreatedAt)
        .append(mText)
        .append(mSource)
        .append(mInReplyToScreenName)
        .append(mInReplyToStatusIdStr)
        .append(mInReplyToUserIdStr)
        .append(mLang)
        .append(mRetweetedStatus)
        .append(mUser)
        .append(mTruncated)
        .append(mIsQuoteStatus)
        .append(mFavorited)
        .append(mRetweeted)
        .append(mId)
        .append(mInReplyToStatusId)
        .append(mInReplyToUserId)
        .append(mFavoriteCount)
        .append(mRetweetCount)
        .toHashCode();
  }

  public Entities getEntities() {
    return mEntities;
  }

  public Entities getExtended_entities() {
    return mExtended_entities;
  }

  public String getIdStr() {
    return mIdStr;
  }

  public String getCreatedAt() {
    return mCreatedAt;
  }

  public String getText() {
    return mText;
  }

  public String getSource() {
    return mSource;
  }

  public String getInReplyToScreenName() {
    return mInReplyToScreenName;
  }

  public String getInReplyToStatusIdStr() {
    return mInReplyToStatusIdStr;
  }

  public String getInReplyToUserIdStr() {
    return mInReplyToUserIdStr;
  }

  public String getLang() {
    return mLang;
  }

  public Tweet getRetweetedStatus() {
    return mRetweetedStatus;
  }

  public User getUser() {
    return mUser;
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

  public long getInReplyToStatusId() {
    return mInReplyToStatusId;
  }

  public long getInReplyToUserId() {
    return mInReplyToUserId;
  }

  public long getFavoriteCount() {
    return mFavoriteCount;
  }

  public long getRetweetCount() {
    return mRetweetCount;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeParcelable(mEntities, 0);
    parcel.writeParcelable(mExtended_entities, 0);
    parcel.writeValue(mIdStr);
    parcel.writeValue(mCreatedAt);
    parcel.writeValue(mText);
    parcel.writeValue(mSource);
    parcel.writeValue(mInReplyToScreenName);
    parcel.writeValue(mInReplyToStatusIdStr);
    parcel.writeValue(mInReplyToUserIdStr);
    parcel.writeValue(mLang);
    parcel.writeParcelable(mRetweetedStatus, 0);
    parcel.writeParcelable(mUser, 0);
    parcel.writeBooleanArray(new boolean[]{mTruncated, mIsQuoteStatus, mFavorited, mRetweeted});
    parcel.writeLong(mId);
    parcel.writeLong(mInReplyToStatusId);
    parcel.writeLong(mInReplyToUserId);
    parcel.writeLong(mFavoriteCount);
    parcel.writeLong(mRetweetCount);
  }

  public void readFromParcel(Parcel source) {
    mEntities = source.readParcelable(Entities.class.getClassLoader());
    mExtended_entities = source.readParcelable(Entities.class.getClassLoader());
    mIdStr = (String) source.readValue(String.class.getClassLoader());
    mCreatedAt = (String) source.readValue(String.class.getClassLoader());
    mText = (String) source.readValue(String.class.getClassLoader());
    mSource = (String) source.readValue(String.class.getClassLoader());
    mInReplyToScreenName = (String) source.readValue(String.class.getClassLoader());
    mInReplyToStatusIdStr = (String) source.readValue(String.class.getClassLoader());
    mInReplyToUserIdStr = (String) source.readValue(String.class.getClassLoader());
    mLang = (String) source.readValue(String.class.getClassLoader());
    mRetweetedStatus = source.readParcelable(Tweet.class.getClassLoader());
    mUser = source.readParcelable(User.class.getClassLoader());
    boolean[] bools = source.createBooleanArray();
    mTruncated = bools[0];
    mIsQuoteStatus = bools[1];
    mFavorited = bools[2];
    mRetweeted = bools[3];
    mId = source.readLong();
    mInReplyToStatusId = source.readLong();
    mInReplyToUserId = source.readLong();
    mFavoriteCount = source.readLong();
    mRetweetCount = source.readLong();
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("entities")) {
      mEntities = Entities.CREATOR.parse(json.getJSONObject("entities"));
    }
    if (!json.isNull("extended_entities")) {
      mExtended_entities = Entities.CREATOR.parse(json.getJSONObject("extended_entities"));
    }
    if (!json.isNull("id_str")) {
      mIdStr = json.optString("id_str");
    }
    if (!json.isNull("created_at")) {
      mCreatedAt = json.optString("created_at");
    }
    if (!json.isNull("text")) {
      mText = json.optString("text");
    }
    if (!json.isNull("source")) {
      mSource = json.optString("source");
    }
    if (!json.isNull("in_reply_to_screen_name")) {
      mInReplyToScreenName = json.optString("in_reply_to_screen_name");
    }
    if (!json.isNull("in_reply_to_status_id_str")) {
      mInReplyToStatusIdStr = json.optString("in_reply_to_status_id_str");
    }
    if (!json.isNull("in_reply_to_user_id_str")) {
      mInReplyToUserIdStr = json.optString("in_reply_to_user_id_str");
    }
    if (!json.isNull("lang")) {
      mLang = json.optString("lang");
    }
    if (!json.isNull("retweeted_status")) {
      mRetweetedStatus = Tweet.CREATOR.parse(json.getJSONObject("retweeted_status"));
    }
    if (!json.isNull("user")) {
      mUser = User.CREATOR.parse(json.getJSONObject("user"));
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
    if (!json.isNull("in_reply_to_status_id")) {
      mInReplyToStatusId = json.optLong("in_reply_to_status_id");
    } else {
      mInReplyToStatusId = -1;
    }
    if (!json.isNull("in_reply_to_user_id")) {
      mInReplyToUserId = json.optLong("in_reply_to_user_id");
    } else {
      mInReplyToUserId = -1;
    }
    if (!json.isNull("favorite_count")) {
      mFavoriteCount = json.optLong("favorite_count");
    } else {
      mFavoriteCount = -1;
    }
    if (!json.isNull("retweet_count")) {
      mRetweetCount = json.optLong("retweet_count");
    } else {
      mRetweetCount = -1;
    }
  }

}
