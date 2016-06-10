package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.NumberUtils;
import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.TwitterUtils;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class User extends _User implements PrintUtils.Printable {
  RichText richUrl;
  RichText richDescription;

  public static final DualCreator<User> CREATOR = new DualCreator<User>() {
    public User[] newArray(int size) {
      return new User[size];
    }

    public User createFromParcel(Parcel source) {
      User object = new User();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public User parse(JSONObject obj) throws JSONException {
      User newInstance = new User();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  public RichText getRichUrl() {
    if (richUrl == null) {
      richUrl = new RichText(getUrl(), getUrlEntities());
    }

    return richUrl;
  }

  public RichText getRichDescription() {
    if (richDescription == null) {
      richDescription = new RichText(getDescription(), getDescriptionEntities());
    }

    return richDescription;
  }

  public List<UrlEntity> getUrlEntities() {
    Entities urlEntities = getEntities().getUrl();
    if (urlEntities == null || urlEntities.getUrls() == null || urlEntities.getUrls().size() < 1) {
      return new ArrayList<>();
    }

    return urlEntities.getUrls();
  }

  public List<UrlEntity> getDescriptionEntities() {
    Entities descriptionEntities = getEntities().getDescription();
    if (descriptionEntities == null || descriptionEntities.getUrls().size() < 1) {
      return new ArrayList<>();
    }

    return descriptionEntities.getUrls();
  }

  public boolean hasUrl() {
    return !getRichUrl().getBaseText().equals("");
  }

  public boolean hasDescription() {
    return !getDescription().equals("");
  }

  public boolean hasLocation() {
    return !getLocation().equals("");
  }

  public String getDisplayScreenName() {
    return TwitterUtils.getDisplayScreenName(getScreenName());
  }

  public String getFavoritesCountString() {
    return NumberUtils.getNumberString(getFavoritesCount());
  }

  public String getFollowersCountString() {
    return NumberUtils.getNumberString(getFollowersCount());
  }

  public String getFriendsCountString() {
    return NumberUtils.getNumberString(getFriendsCount());
  }

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "idStr",
        "description",
        "lang",
        "location",
        "name",
        "profileBackgroundColor",
        "profileBackgroundImageUrl",
        "profileBackgroundImageUrlHttps",
        "profileBannerUrl",
        "profileImageUrl",
        "profileImageUrlHttps",
        "profileLinkColor",
        "profileSidebarBorderColor",
        "profileSidebarFillColor",
        "profileTextColor",
        "screenName",
        "timeZone",
        "url",
        "withheldInCountries",
        "withheldScope",
        "id",
        "favoritesCount",
        "followersCount",
        "friendsCount",
        "listedCount",
        "statusesCount",
        "utcOffset",
        "contributersEnabled",
        "defaultProfile",
        "defaultProfileImage",
        "followRequestSent",
        "following",
        "geoEnabled",
        "notifications",
        "profileBackgroundTile",
        "profileUseBackgroundImage",
        "showAllInlineMedia",
        "verified",
        "entities"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        getIdStr(),
        getDescription(),
        getLang(),
        getLocation(),
        getName(),
        getProfileBackgroundColor(),
        getProfileBackgroundImageUrl(),
        getProfileBackgroundImageUrlHttps(),
        getProfileBannerUrl(),
        getProfileImageUrl(),
        getProfileImageUrlHttps(),
        getProfileLinkColor(),
        getProfileSidebarBorderColor(),
        getProfileSidebarFillColor(),
        getProfileTextColor(),
        getScreenName(),
        getTimeZone(),
        getUrl(),
        getWithheldInCountries(),
        getWithheldScope(),
        getId() + "",
        getFavoritesCount() + "",
        getFollowersCount() + "",
        getFriendsCount() + "",
        getListedCount() + "",
        getStatusesCount() + "",
        getUtcOffset() + "",
        getContributersEnabled() + "",
        getDefaultProfile() + "",
        getDefaultProfileImage() + "",
        getFollowRequestSent() + "",
        getFollowing() + "",
        getGeoEnabled() + "",
        getNotifications() + "",
        getProfileBackgroundTile() + "",
        getProfileUseBackgroundImage() + "",
        getShowAllInlineMedia() + "",
        getVerified() + "",
        PrintUtils.toString(getEntities(), "")
    };

    return values;
  }
}
