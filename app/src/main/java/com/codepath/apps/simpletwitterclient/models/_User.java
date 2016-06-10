package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Automatically generated Parcelable implementation for _User.
 * DO NOT MODIFY THIS FILE MANUALLY! IT WILL BE OVERWRITTEN THE NEXT TIME
 * _User's PARCELABLE DESCRIPTION IS CHANGED.
 */
/* package */ abstract class _User implements Parcelable {

  protected String mIdStr;
  protected String mDescription;
  protected String mLang;
  protected String mLocation;
  protected String mName;
  protected String mProfileBackgroundColor;
  protected String mProfileBackgroundImageUrl;
  protected String mProfileBackgroundImageUrlHttps;
  protected String mProfileBannerUrl;
  protected String mProfileImageUrl;
  protected String mProfileImageUrlHttps;
  protected String mProfileLinkColor;
  protected String mProfileSidebarBorderColor;
  protected String mProfileSidebarFillColor;
  protected String mProfileTextColor;
  protected String mScreenName;
  protected String mTimeZone;
  protected String mUrl;
  protected String mWithheldInCountries;
  protected String mWithheldScope;
  protected Tweet mStatus;
  protected UserEntities mEntities;
  protected boolean mContributersEnabled;
  protected boolean mDefaultProfile;
  protected boolean mDefaultProfileImage;
  protected boolean mFollowRequestSent;
  protected boolean mFollowing;
  protected boolean mGeoEnabled;
  protected boolean mIsTranslator;
  protected boolean mNotifications;
  protected boolean mProfileBackgroundTile;
  protected boolean mProfileUseBackgroundImage;
  protected boolean mIsProtected;
  protected boolean mShowAllInlineMedia;
  protected boolean mVerified;
  protected long mId;
  protected long mFavoritesCount;
  protected long mFollowersCount;
  protected long mFriendsCount;
  protected long mListedCount;
  protected long mStatusesCount;
  protected long mUtcOffset;

  protected _User(String idStr, String description, String lang, String location, String name, String profileBackgroundColor, String profileBackgroundImageUrl, String profileBackgroundImageUrlHttps, String profileBannerUrl, String profileImageUrl, String profileImageUrlHttps, String profileLinkColor, String profileSidebarBorderColor, String profileSidebarFillColor, String profileTextColor, String screenName, String timeZone, String url, String withheldInCountries, String withheldScope, Tweet status, UserEntities entities, boolean contributersEnabled, boolean defaultProfile, boolean defaultProfileImage, boolean followRequestSent, boolean following, boolean geoEnabled, boolean isTranslator, boolean notifications, boolean profileBackgroundTile, boolean profileUseBackgroundImage, boolean isProtected, boolean showAllInlineMedia, boolean verified, long id, long favoritesCount, long followersCount, long friendsCount, long listedCount, long statusesCount, long utcOffset) {
    this();
    mIdStr = idStr;
    mDescription = description;
    mLang = lang;
    mLocation = location;
    mName = name;
    mProfileBackgroundColor = profileBackgroundColor;
    mProfileBackgroundImageUrl = profileBackgroundImageUrl;
    mProfileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    mProfileBannerUrl = profileBannerUrl;
    mProfileImageUrl = profileImageUrl;
    mProfileImageUrlHttps = profileImageUrlHttps;
    mProfileLinkColor = profileLinkColor;
    mProfileSidebarBorderColor = profileSidebarBorderColor;
    mProfileSidebarFillColor = profileSidebarFillColor;
    mProfileTextColor = profileTextColor;
    mScreenName = screenName;
    mTimeZone = timeZone;
    mUrl = url;
    mWithheldInCountries = withheldInCountries;
    mWithheldScope = withheldScope;
    mStatus = status;
    mEntities = entities;
    mContributersEnabled = contributersEnabled;
    mDefaultProfile = defaultProfile;
    mDefaultProfileImage = defaultProfileImage;
    mFollowRequestSent = followRequestSent;
    mFollowing = following;
    mGeoEnabled = geoEnabled;
    mIsTranslator = isTranslator;
    mNotifications = notifications;
    mProfileBackgroundTile = profileBackgroundTile;
    mProfileUseBackgroundImage = profileUseBackgroundImage;
    mIsProtected = isProtected;
    mShowAllInlineMedia = showAllInlineMedia;
    mVerified = verified;
    mId = id;
    mFavoritesCount = favoritesCount;
    mFollowersCount = followersCount;
    mFriendsCount = friendsCount;
    mListedCount = listedCount;
    mStatusesCount = statusesCount;
    mUtcOffset = utcOffset;
  }

  protected _User() {
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

    _User that = (_User) object;

    return new EqualsBuilder()
        .append(this.mIdStr, that.mIdStr)
        .append(this.mDescription, that.mDescription)
        .append(this.mLang, that.mLang)
        .append(this.mLocation, that.mLocation)
        .append(this.mName, that.mName)
        .append(this.mProfileBackgroundColor, that.mProfileBackgroundColor)
        .append(this.mProfileBackgroundImageUrl, that.mProfileBackgroundImageUrl)
        .append(this.mProfileBackgroundImageUrlHttps, that.mProfileBackgroundImageUrlHttps)
        .append(this.mProfileBannerUrl, that.mProfileBannerUrl)
        .append(this.mProfileImageUrl, that.mProfileImageUrl)
        .append(this.mProfileImageUrlHttps, that.mProfileImageUrlHttps)
        .append(this.mProfileLinkColor, that.mProfileLinkColor)
        .append(this.mProfileSidebarBorderColor, that.mProfileSidebarBorderColor)
        .append(this.mProfileSidebarFillColor, that.mProfileSidebarFillColor)
        .append(this.mProfileTextColor, that.mProfileTextColor)
        .append(this.mScreenName, that.mScreenName)
        .append(this.mTimeZone, that.mTimeZone)
        .append(this.mUrl, that.mUrl)
        .append(this.mWithheldInCountries, that.mWithheldInCountries)
        .append(this.mWithheldScope, that.mWithheldScope)
        .append(this.mStatus, that.mStatus)
        .append(this.mEntities, that.mEntities)
        .append(this.mContributersEnabled, that.mContributersEnabled)
        .append(this.mDefaultProfile, that.mDefaultProfile)
        .append(this.mDefaultProfileImage, that.mDefaultProfileImage)
        .append(this.mFollowRequestSent, that.mFollowRequestSent)
        .append(this.mFollowing, that.mFollowing)
        .append(this.mGeoEnabled, that.mGeoEnabled)
        .append(this.mIsTranslator, that.mIsTranslator)
        .append(this.mNotifications, that.mNotifications)
        .append(this.mProfileBackgroundTile, that.mProfileBackgroundTile)
        .append(this.mProfileUseBackgroundImage, that.mProfileUseBackgroundImage)
        .append(this.mIsProtected, that.mIsProtected)
        .append(this.mShowAllInlineMedia, that.mShowAllInlineMedia)
        .append(this.mVerified, that.mVerified)
        .append(this.mId, that.mId)
        .append(this.mFavoritesCount, that.mFavoritesCount)
        .append(this.mFollowersCount, that.mFollowersCount)
        .append(this.mFriendsCount, that.mFriendsCount)
        .append(this.mListedCount, that.mListedCount)
        .append(this.mStatusesCount, that.mStatusesCount)
        .append(this.mUtcOffset, that.mUtcOffset)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder()
        .append(mIdStr)
        .append(mDescription)
        .append(mLang)
        .append(mLocation)
        .append(mName)
        .append(mProfileBackgroundColor)
        .append(mProfileBackgroundImageUrl)
        .append(mProfileBackgroundImageUrlHttps)
        .append(mProfileBannerUrl)
        .append(mProfileImageUrl)
        .append(mProfileImageUrlHttps)
        .append(mProfileLinkColor)
        .append(mProfileSidebarBorderColor)
        .append(mProfileSidebarFillColor)
        .append(mProfileTextColor)
        .append(mScreenName)
        .append(mTimeZone)
        .append(mUrl)
        .append(mWithheldInCountries)
        .append(mWithheldScope)
        .append(mStatus)
        .append(mEntities)
        .append(mContributersEnabled)
        .append(mDefaultProfile)
        .append(mDefaultProfileImage)
        .append(mFollowRequestSent)
        .append(mFollowing)
        .append(mGeoEnabled)
        .append(mIsTranslator)
        .append(mNotifications)
        .append(mProfileBackgroundTile)
        .append(mProfileUseBackgroundImage)
        .append(mIsProtected)
        .append(mShowAllInlineMedia)
        .append(mVerified)
        .append(mId)
        .append(mFavoritesCount)
        .append(mFollowersCount)
        .append(mFriendsCount)
        .append(mListedCount)
        .append(mStatusesCount)
        .append(mUtcOffset)
        .toHashCode();
  }

  public String getIdStr() {
    return mIdStr;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getLang() {
    return mLang;
  }

  public String getLocation() {
    return mLocation;
  }

  public String getName() {
    return mName;
  }

  public String getProfileBackgroundColor() {
    return mProfileBackgroundColor;
  }

  public String getProfileBackgroundImageUrl() {
    return mProfileBackgroundImageUrl;
  }

  public String getProfileBackgroundImageUrlHttps() {
    return mProfileBackgroundImageUrlHttps;
  }

  public String getProfileBannerUrl() {
    return mProfileBannerUrl;
  }

  public String getProfileImageUrl() {
    return mProfileImageUrl;
  }

  public String getProfileImageUrlHttps() {
    return mProfileImageUrlHttps;
  }

  public String getProfileLinkColor() {
    return mProfileLinkColor;
  }

  public String getProfileSidebarBorderColor() {
    return mProfileSidebarBorderColor;
  }

  public String getProfileSidebarFillColor() {
    return mProfileSidebarFillColor;
  }

  public String getProfileTextColor() {
    return mProfileTextColor;
  }

  public String getScreenName() {
    return mScreenName;
  }

  public String getTimeZone() {
    return mTimeZone;
  }

  public String getUrl() {
    return mUrl;
  }

  public String getWithheldInCountries() {
    return mWithheldInCountries;
  }

  public String getWithheldScope() {
    return mWithheldScope;
  }

  public Tweet getStatus() {
    return mStatus;
  }

  public UserEntities getEntities() {
    return mEntities;
  }

  public boolean getContributersEnabled() {
    return mContributersEnabled;
  }

  public boolean getDefaultProfile() {
    return mDefaultProfile;
  }

  public boolean getDefaultProfileImage() {
    return mDefaultProfileImage;
  }

  public boolean getFollowRequestSent() {
    return mFollowRequestSent;
  }

  public boolean getFollowing() {
    return mFollowing;
  }

  public boolean getGeoEnabled() {
    return mGeoEnabled;
  }

  public boolean isTranslator() {
    return mIsTranslator;
  }

  public boolean getNotifications() {
    return mNotifications;
  }

  public boolean getProfileBackgroundTile() {
    return mProfileBackgroundTile;
  }

  public boolean getProfileUseBackgroundImage() {
    return mProfileUseBackgroundImage;
  }

  public boolean isProtected() {
    return mIsProtected;
  }

  public boolean getShowAllInlineMedia() {
    return mShowAllInlineMedia;
  }

  public boolean getVerified() {
    return mVerified;
  }

  public long getId() {
    return mId;
  }

  public long getFavoritesCount() {
    return mFavoritesCount;
  }

  public long getFollowersCount() {
    return mFollowersCount;
  }

  public long getFriendsCount() {
    return mFriendsCount;
  }

  public long getListedCount() {
    return mListedCount;
  }

  public long getStatusesCount() {
    return mStatusesCount;
  }

  public long getUtcOffset() {
    return mUtcOffset;
  }


  public int describeContents() {
    return 0;
  }

  public void writeToParcel(Parcel parcel, int flags) {
    parcel.writeValue(mIdStr);
    parcel.writeValue(mDescription);
    parcel.writeValue(mLang);
    parcel.writeValue(mLocation);
    parcel.writeValue(mName);
    parcel.writeValue(mProfileBackgroundColor);
    parcel.writeValue(mProfileBackgroundImageUrl);
    parcel.writeValue(mProfileBackgroundImageUrlHttps);
    parcel.writeValue(mProfileBannerUrl);
    parcel.writeValue(mProfileImageUrl);
    parcel.writeValue(mProfileImageUrlHttps);
    parcel.writeValue(mProfileLinkColor);
    parcel.writeValue(mProfileSidebarBorderColor);
    parcel.writeValue(mProfileSidebarFillColor);
    parcel.writeValue(mProfileTextColor);
    parcel.writeValue(mScreenName);
    parcel.writeValue(mTimeZone);
    parcel.writeValue(mUrl);
    parcel.writeValue(mWithheldInCountries);
    parcel.writeValue(mWithheldScope);
    parcel.writeParcelable(mStatus, 0);
    parcel.writeParcelable(mEntities, 0);
    parcel.writeBooleanArray(new boolean[]{mContributersEnabled, mDefaultProfile, mDefaultProfileImage, mFollowRequestSent, mFollowing, mGeoEnabled, mIsTranslator, mNotifications, mProfileBackgroundTile, mProfileUseBackgroundImage, mIsProtected, mShowAllInlineMedia, mVerified});
    parcel.writeLong(mId);
    parcel.writeLong(mFavoritesCount);
    parcel.writeLong(mFollowersCount);
    parcel.writeLong(mFriendsCount);
    parcel.writeLong(mListedCount);
    parcel.writeLong(mStatusesCount);
    parcel.writeLong(mUtcOffset);
  }

  public void readFromParcel(Parcel source) {
    mIdStr = (String) source.readValue(String.class.getClassLoader());
    mDescription = (String) source.readValue(String.class.getClassLoader());
    mLang = (String) source.readValue(String.class.getClassLoader());
    mLocation = (String) source.readValue(String.class.getClassLoader());
    mName = (String) source.readValue(String.class.getClassLoader());
    mProfileBackgroundColor = (String) source.readValue(String.class.getClassLoader());
    mProfileBackgroundImageUrl = (String) source.readValue(String.class.getClassLoader());
    mProfileBackgroundImageUrlHttps = (String) source.readValue(String.class.getClassLoader());
    mProfileBannerUrl = (String) source.readValue(String.class.getClassLoader());
    mProfileImageUrl = (String) source.readValue(String.class.getClassLoader());
    mProfileImageUrlHttps = (String) source.readValue(String.class.getClassLoader());
    mProfileLinkColor = (String) source.readValue(String.class.getClassLoader());
    mProfileSidebarBorderColor = (String) source.readValue(String.class.getClassLoader());
    mProfileSidebarFillColor = (String) source.readValue(String.class.getClassLoader());
    mProfileTextColor = (String) source.readValue(String.class.getClassLoader());
    mScreenName = (String) source.readValue(String.class.getClassLoader());
    mTimeZone = (String) source.readValue(String.class.getClassLoader());
    mUrl = (String) source.readValue(String.class.getClassLoader());
    mWithheldInCountries = (String) source.readValue(String.class.getClassLoader());
    mWithheldScope = (String) source.readValue(String.class.getClassLoader());
    mStatus = source.readParcelable(Tweet.class.getClassLoader());
    mEntities = source.readParcelable(UserEntities.class.getClassLoader());
    boolean[] bools = source.createBooleanArray();
    mContributersEnabled = bools[0];
    mDefaultProfile = bools[1];
    mDefaultProfileImage = bools[2];
    mFollowRequestSent = bools[3];
    mFollowing = bools[4];
    mGeoEnabled = bools[5];
    mIsTranslator = bools[6];
    mNotifications = bools[7];
    mProfileBackgroundTile = bools[8];
    mProfileUseBackgroundImage = bools[9];
    mIsProtected = bools[10];
    mShowAllInlineMedia = bools[11];
    mVerified = bools[12];
    mId = source.readLong();
    mFavoritesCount = source.readLong();
    mFollowersCount = source.readLong();
    mFriendsCount = source.readLong();
    mListedCount = source.readLong();
    mStatusesCount = source.readLong();
    mUtcOffset = source.readLong();
  }

  public void readFromJson(JSONObject json) throws JSONException {
    if (!json.isNull("id_str")) {
      mIdStr = json.optString("id_str");
    }
    if (!json.isNull("description")) {
      mDescription = json.optString("description");
    }
    if (!json.isNull("lang")) {
      mLang = json.optString("lang");
    }
    if (!json.isNull("location")) {
      mLocation = json.optString("location");
    }
    if (!json.isNull("name")) {
      mName = json.optString("name");
    }
    if (!json.isNull("profile_background_color")) {
      mProfileBackgroundColor = json.optString("profile_background_color");
    }
    if (!json.isNull("profile_background_image_url")) {
      mProfileBackgroundImageUrl = json.optString("profile_background_image_url");
    }
    if (!json.isNull("profile_background_image_url_https")) {
      mProfileBackgroundImageUrlHttps = json.optString("profile_background_image_url_https");
    }
    if (!json.isNull("profile_banner_url")) {
      mProfileBannerUrl = json.optString("profile_banner_url");
    }
    if (!json.isNull("profile_image_url")) {
      mProfileImageUrl = json.optString("profile_image_url");
    }
    if (!json.isNull("profile_image_url_https")) {
      mProfileImageUrlHttps = json.optString("profile_image_url_https");
    }
    if (!json.isNull("profile_link_color")) {
      mProfileLinkColor = json.optString("profile_link_color");
    }
    if (!json.isNull("profile_sidebar_border_color")) {
      mProfileSidebarBorderColor = json.optString("profile_sidebar_border_color");
    }
    if (!json.isNull("profile_sidebar_fill_color")) {
      mProfileSidebarFillColor = json.optString("profile_sidebar_fill_color");
    }
    if (!json.isNull("profile_text_color")) {
      mProfileTextColor = json.optString("profile_text_color");
    }
    if (!json.isNull("screen_name")) {
      mScreenName = json.optString("screen_name");
    }
    if (!json.isNull("time_zone")) {
      mTimeZone = json.optString("time_zone");
    }
    if (!json.isNull("url")) {
      mUrl = json.optString("url");
    }
    if (!json.isNull("withheld_in_countries")) {
      mWithheldInCountries = json.optString("withheld_in_countries");
    }
    if (!json.isNull("withheld_scope")) {
      mWithheldScope = json.optString("withheld_scope");
    }
    if (!json.isNull("status")) {
      mStatus = Tweet.CREATOR.parse(json.getJSONObject("status"));
    }
    if (!json.isNull("entities")) {
      mEntities = UserEntities.CREATOR.parse(json.getJSONObject("entities"));
    }
    mContributersEnabled = json.optBoolean("contributers_enabled");
    mDefaultProfile = json.optBoolean("default_profile");
    mDefaultProfileImage = json.optBoolean("default_profile_image");
    mFollowRequestSent = json.optBoolean("follow_request_sent");
    mFollowing = json.optBoolean("following");
    mGeoEnabled = json.optBoolean("geo_enabled");
    mIsTranslator = json.optBoolean("is_translator");
    mNotifications = json.optBoolean("notifications");
    mProfileBackgroundTile = json.optBoolean("profile_background_tile");
    mProfileUseBackgroundImage = json.optBoolean("profile_use_background_image");
    mIsProtected = json.optBoolean("protected");
    mShowAllInlineMedia = json.optBoolean("show_all_inline_media");
    mVerified = json.optBoolean("verified");
    if (!json.isNull("id")) {
      mId = json.optLong("id");
    } else {
      mId = -1;
    }
    if (!json.isNull("favorites_count")) {
      mFavoritesCount = json.optLong("favorites_count");
    } else {
      mFavoritesCount = -1;
    }
    if (!json.isNull("followers_count")) {
      mFollowersCount = json.optLong("followers_count");
    } else {
      mFollowersCount = -1;
    }
    if (!json.isNull("friends_count")) {
      mFriendsCount = json.optLong("friends_count");
    }
    if (!json.isNull("listed_count")) {
      mListedCount = json.optLong("listed_count");
    } else {
      mListedCount = -1;
    }
    if (!json.isNull("statuses_count")) {
      mStatusesCount = json.optLong("statuses_count");
    }
    if (!json.isNull("utc_offset")) {
      mUtcOffset = json.optLong("utc_offset");
    } else {
      mUtcOffset = -1;
    }
  }

}
