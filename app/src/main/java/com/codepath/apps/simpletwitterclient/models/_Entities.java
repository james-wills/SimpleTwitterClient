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
 * Automatically generated Parcelable implementation for _Entities.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _Entities's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _Entities implements Parcelable {

  protected List<HashtagEntity> mHashtags;
  protected List<MediaEntity> mMedia;
  protected List<MentionEntity> mMentions;
  protected List<SymbolEntity> mSymbols;
  protected List<UrlEntity> mUrls;

  protected _Entities(List<HashtagEntity> hashtags, List<MediaEntity> media, List<MentionEntity> mentions, List<SymbolEntity> symbols, List<UrlEntity> urls) {
    this();
    mHashtags = hashtags;
    mMedia = media;
    mMentions = mentions;
    mSymbols = symbols;
    mUrls = urls;
  }

  protected _Entities() {
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

    _Entities that = (_Entities) object;

    return new EqualsBuilder()
        .append(this.mHashtags, that.mHashtags)
        .append(this.mMedia, that.mMedia)
        .append(this.mMentions, that.mMentions)
        .append(this.mSymbols, that.mSymbols)
        .append(this.mUrls, that.mUrls)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mHashtags)
        .append(mMedia)
        .append(mMentions)
        .append(mSymbols)
        .append(mUrls)
        .toHashCode();
  }

  public List<HashtagEntity> getHashtags() {
    return mHashtags;
  }

  public List<MediaEntity> getMedia() {
    return mMedia;
  }

  public List<MentionEntity> getMentions() {
    return mMentions;
  }

  public List<SymbolEntity> getSymbols() {
    return mSymbols;
  }

  public List<UrlEntity> getUrls() {
    return mUrls;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeList(mHashtags);
    parcel.writeList(mMedia);
    parcel.writeList(mMentions);
    parcel.writeList(mSymbols);
    parcel.writeList(mUrls);
  }

  public void readFromParcel(Parcel source) {
    mHashtags = source.readArrayList(HashtagEntity.class.getClassLoader());
    mMedia = source.readArrayList(MediaEntity.class.getClassLoader());
    mMentions = source.readArrayList(MentionEntity.class.getClassLoader());
    mSymbols = source.readArrayList(SymbolEntity.class.getClassLoader());
    mUrls = source.readArrayList(UrlEntity.class.getClassLoader());
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("hashtags")) {
      mHashtags = JsonUtil.parseJsonList(json.optJSONArray("hashtags"), HashtagEntity.CREATOR);
    } else {
      mHashtags = java.util.Collections.emptyList();
    }
    if (!json.isNull("media")) {
      mMedia = JsonUtil.parseJsonList(json.optJSONArray("media"), MediaEntity.CREATOR);
    } else {
      mMedia = java.util.Collections.emptyList();
    }
    if (!json.isNull("user_mentions")) {
      mMentions = JsonUtil.parseJsonList(json.optJSONArray("user_mentions"), MentionEntity.CREATOR);
    } else {
      mMentions = java.util.Collections.emptyList();
    }
    if (!json.isNull("symbols")) {
      mSymbols = JsonUtil.parseJsonList(json.optJSONArray("symbols"), SymbolEntity.CREATOR);
    } else {
      mSymbols = java.util.Collections.emptyList();
    }
    if (!json.isNull("urls")) {
      mUrls = JsonUtil.parseJsonList(json.optJSONArray("urls"), UrlEntity.CREATOR);
    } else {
      mUrls = java.util.Collections.emptyList();
    }
  }

}
