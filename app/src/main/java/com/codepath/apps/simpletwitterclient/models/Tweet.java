package com.codepath.apps.simpletwitterclient.models;

import com.codepath.apps.simpletwitterclient.utils.JsonHelper;
import com.codepath.apps.simpletwitterclient.utils.TimeUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by james_wills on 6/1/16.
 */
public class Tweet {
  public static final int MAX_CHARACTERS = 140;
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

  public String getTimeSinceCreation() throws ParseException {
    Date tweetDate = TimeUtil.getTwitterApiDateFormat().parse(createdAt);
    PrettyTime formatter = TimeUtil.getTimeFormatter();
    return formatter.format(formatter.approximateDuration(tweetDate));
  }

  public RichText getTweetText() {
    return tweetText;
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
      List<MediaLink> baseMedia = MediaLink.mediaFromJsonArray(
          JsonHelper.getJsonArray(entities, "media", new JSONArray()));

      JSONObject extendedEntities = JsonHelper.getJSONObject(o, "extended_entities", new JSONObject());

      media = MediaLink.mediaFromJsonArray(
          JsonHelper.getJsonArray(extendedEntities, "media", new JSONArray()));

      tweetText = new RichText(body, mentions, hashtags, urls, baseMedia);

      retweetCount = o.getLong("retweet_count");
      favoriteCount = o.getLong("favorite_count");
      inReplyToStatusId = JsonHelper.getLong(o, "in_reply_to_status_id", INVALID_TWEET_ID);

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
    String s = "";
    s += "User: " + user.toString();
    s += "\ntweetText: " + tweetText.toString();
    s += "\ncreatedAt: " + createdAt;
    s += "\nRetweetCount: " + retweetCount;
    s += "\nFavoriteCount: " + favoriteCount;
    s += "\ninReplyToStatusId: " + inReplyToStatusId;
    s += "\nmedia: ";
    for (MediaLink m : media) {
      s += "\nMEDIA LINK\n" + m.toString() + "\n";
    }

    return s;
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
