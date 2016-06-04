package com.codepath.apps.simpletwitterclient.models;

import android.text.Spannable;
import android.text.Spanned;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james_wills on 6/1/16.
 */
public class Tweet {
  public static final long INVALID_TWEET_ID = -1;

  private long tweetId;
  private User user;
  private String createdAt;
  private RichText tweetText;
  private long retweetCount;
  private long favoriteCount;
  private long inReplyToStatusId;
  private Tweet retweetedStatus; // null if not a retweet
  private List<MediaLink> media;

  public long getTweetId() {
    return tweetId;
  }

  public User getUser() {
    return user;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public RichText getTweetText() {
    return tweetText;
  }

  public long getRetweetCount() {
    return retweetCount;
  }

  public long getFavoriteCount() {
    return favoriteCount;
  }

  public long getInReplyToStatusId() {
    return inReplyToStatusId;
  }

  public Tweet getRetweetedStatus() {
    return retweetedStatus;
  }

  public List<MediaLink> getMedia() {
    return media;
  }

  public Tweet(JSONObject o) {
    try {
      this.tweetId = o.getLong("id");
      this.createdAt = o.getString("created_at");
      this.user = User.fromJSON(o.getJSONObject("user"));

      String body = o.getString("text");
      JSONObject entities = o.getJSONObject("entities");
      List<Mention> mentions = Mention.fromJsonArray(entities.getJSONArray("user_mentions"));
      List<TextUrl> urls = TextUrl.fromJsonArray(entities.getJSONArray("urls"));
      List<Hashtag> hashtags = Hashtag.fromJsonArray(entities.getJSONArray("hashtags"));

      if (entities.has("media")) {
        media = MediaLink.mediaFromJsonArray(entities.getJSONArray("media"));
      } else {
        media = new ArrayList<MediaLink>();
      }
      tweetText = new RichText(body, mentions, hashtags, urls, media);

      retweetCount = o.getLong("retweet_count");
      favoriteCount = o.getLong("favorite_count");

      if (o.has("in_reply_to_status_id") && !o.isNull("in_reply_to_status_id")) {
        inReplyToStatusId = o.getLong("in_reply_to_status_id");
      } else {
        inReplyToStatusId = INVALID_TWEET_ID;
      }

      if (o.has("retweeted_status")) {
        retweetedStatus = new Tweet(o.getJSONObject("retweeted_status"));
      } else {
        retweetedStatus = null;
      }

    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return tweetText.toString();
  }

  public static List<Tweet> fromJSONArray(JSONArray arr) {
    ArrayList<Tweet> tweets = new ArrayList<>();
    for (int i = 0; i < arr.length(); i++) {
      try {
        Tweet t = new Tweet(arr.getJSONObject(i));
        if (t != null) {
          tweets.add(t);
        }
      } catch (JSONException e) {
        e.printStackTrace();
        continue;
      }
    }

    return tweets;
  }
}
