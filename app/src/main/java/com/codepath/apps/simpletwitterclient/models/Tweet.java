package com.codepath.apps.simpletwitterclient.models;

import android.os.Parcel;

import com.codepath.apps.simpletwitterclient.utils.NumberUtils;
import com.codepath.apps.simpletwitterclient.utils.PrintUtils;
import com.codepath.apps.simpletwitterclient.utils.TimeUtil;
import com.codepath.apps.simpletwitterclient.utils.parcelgen.JsonParser.DualCreator;

import org.json.JSONException;
import org.json.JSONObject;
import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Tweet extends _Tweet implements PrintUtils.Printable {
  public static final int INVALID_TWEET_ID = -1;
  public static final int MAX_CHARACTERS = 140;

  private RichText richTweet;

  public static final DualCreator<Tweet> CREATOR = new DualCreator<Tweet>() {

    public Tweet[] newArray(int size) {
      return new Tweet[size];
    }

    public Tweet createFromParcel(Parcel source) {
      Tweet object = new Tweet();
      object.readFromParcel(source);
      return object;
    }

    @Override
    public Tweet parse(JSONObject obj) throws JSONException {
      Tweet newInstance = new Tweet();
      newInstance.readFromJson(obj);
      return newInstance;
    }
  };

  public long getTweetId() {
    return getId();
  }

  @Override
  public User getUser() {
    return super.getUser();
  }

  public String getTimeSinceCreation() throws ParseException {
    Date tweetDate = TimeUtil.getTwitterApiDateFormat().parse(getCreatedAt());
    PrettyTime formatter = TimeUtil.getTimeFormatter();
    return formatter.format(formatter.approximateDuration(tweetDate));
  }

  public RichText getTweetText() {
    if (richTweet == null) {
      Entities e = getEntities();
      richTweet = new RichText(getText(), e.getMentions(), e.getHashtags(), e.getUrls(), e.getMedia());
    }

    return richTweet;
  }

  @Override
  public Tweet getRetweetedStatus() {
    return super.getRetweetedStatus();
  }

  public List<MediaEntity> getMedia() {
    if (getExtended_entities() == null) {
      return new ArrayList<>();
    }

    return getExtended_entities().getMedia();
  }

  @Override
  public String[] getPrintKeys() {
    String[] labels = {
        "user",
        "idStr",
        "createdAt",
        "text",
        "source",
        "inReplyToScreenName",
        "inReplyToStatusIdStr",
        "inReplyToUserIdStr",
        "lang",
        "id",
        "inReplyToStatusId",
        "inReplyToUserId",
        "favoriteCount",
        "retweetCount",
        "truncated",
        "favorited",
        "retweeted",
        "entities",
        "extended_entities",
        "retweetedStatus"
    };

    return labels;
  }

  @Override
  public String[] getPrintValues() {
    String[] values = {
        PrintUtils.toString(getUser()),
        getIdStr(),
        getCreatedAt(),
        getText(),
        getSource(),
        getInReplyToScreenName(),
        getInReplyToStatusIdStr(),
        getInReplyToUserIdStr(),
        getLang(),
        getId() + "",
        getInReplyToStatusId() + "",
        getInReplyToUserId() + "",
        getFavoriteCount() + "",
        getRetweetCount() + "",
        getTruncated() + "",
        getFavorited() + "",
        getRetweeted() + "",
        PrintUtils.toString(getEntities()),
        PrintUtils.toString(getExtended_entities()),
        PrintUtils.toString(getRetweetedStatus())
    };

    return values;
  }

  public String getFavoriteCountString() {
    return NumberUtils.getNumberString(getFavoriteCount());
  }

  public String getRetweetCountString() {
    return NumberUtils.getNumberString(getRetweetCount());
  }
}
