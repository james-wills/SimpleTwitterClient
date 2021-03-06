package com.codepath.apps.simpletwitterclient.twitterapi;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

import android.content.Context;

import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
  public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class;
  public static final String REST_URL = "https://api.twitter.com/1.1";
  public static final String REST_CONSUMER_KEY = "QlwPgkdHIku5poXzeKPGRmDic";
  public static final String REST_CONSUMER_SECRET = "glNmAvxV0Csm2Ykfw9AcxF8Mh259DRntFfcfkRzKRrUvNaIx0D";
  public static final String REST_CALLBACK_URL = "oauth://cptweets"; //   Change this (here and in manifest)

  public static final int TWEETS_PER_PAGE = 200;

  public TwitterClient(Context context) {
    super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
  }

  // GET /statuses/home_timeline.json
  //    count = (0 - 200)
  //    since_id = results w/ id more recent than given id
  //    https://dev.twitter.com/rest/reference/get/statuses/home_timeline
	public void getHomeTimeline(long maxId, AsyncHttpResponseHandler handler) {
		String apiUrl = getApiUrl("statuses/home_timeline.json");
		RequestParams params = new RequestParams();
    addCountToParams(TWEETS_PER_PAGE, params);
    addMaxIdToParams(maxId, params);
		getClient().get(apiUrl, params, handler);
	}
  
  // GET /statuses/user_timeline.json
  //    user_id
  //    count
  //    max_id
  //    https://dev.twitter.com/rest/reference/get/statuses/user_timeline
  public void getUserTimeline(String screenName, long maxId, AsyncHttpResponseHandler handler) {
    String apiUrl = getApiUrl("statuses/user_timeline.json");
    RequestParams params = new RequestParams();
    addCountToParams(TWEETS_PER_PAGE, params);
    addScreenNameToParams(screenName, params);
    addMaxIdToParams(maxId, params);
    getClient().get(apiUrl, params, handler);
  }

  public void getUserInfo(String screenName, AsyncHttpResponseHandler handler) {
    String apiUrl = getApiUrl("users/show.json");
    RequestParams params = new RequestParams();
    addScreenNameToParams(screenName, params);
    getClient().get(apiUrl, params, handler);
  }

  public void getCurrentUser(AsyncHttpResponseHandler handler) {
    String apiUrl = getApiUrl("account/verify_credentials.json");
    getClient().get(apiUrl, null, handler);
  }
  
  // GET /statuses/mentions_timeline.json
  //    count
  //    since_id
  //    max_id
  //    https://dev.twitter.com/rest/reference/get/statuses/mentions_timeline
  public void getMentionsTimeline(long maxId, AsyncHttpResponseHandler handler) {
    String apiUrl = getApiUrl("statuses/mentions_timeline.json");
    RequestParams params = new RequestParams();
    addCountToParams(TWEETS_PER_PAGE, params);
    addMaxIdToParams(maxId, params);
    getClient().get(apiUrl, params, handler);
  }

  public void getFavoritesTimeline(String screenName, long maxId, AsyncHttpResponseHandler handler) {
    String apiUrl = getApiUrl("favorites/list.json");
    RequestParams params = new RequestParams();
    addCountToParams(TWEETS_PER_PAGE, params);
    addScreenNameToParams(screenName, params);
    addMaxIdToParams(maxId, params);
    getClient().get(apiUrl, params, handler);
  }

  // GET /statuses/show/:id.json
  //    id
  //    include_my_retweet = true
  //   result
  //    https://dev.twitter.com/rest/reference/get/statuses/show/%3Aid

  // GET /friends/list.json
  //    user_id
  //    cursor (-1 is first page)
  //    count (0-200)
  //    https://dev.twitter.com/rest/reference/get/friends/list

  // POST statuses/update.json
  //    status
  //    in_reply_to_status_id
  //    https://dev.twitter.com/rest/reference/post/statuses/update
  public void postTweet(String tweet, AsyncHttpResponseHandler handler) {
    String apiUrl = getApiUrl("statuses/update.json");
    RequestParams params = new RequestParams();
    params.put("status", tweet);
    getClient().post(apiUrl, params, handler);
  }

  // POST statuses/destroy/:id.json
  //    https://dev.twitter.com/rest/reference/post/statuses/destroy/%3Aid

  // POST statuses/retweet/:id.json
  //    https://dev.twitter.com/rest/reference/post/statuses/retweet/%3Aid

  // POST statuses/unretweet/:id.json
  //    https://dev.twitter.com/rest/reference/post/statuses/unretweet/%3Aid

  private static RequestParams addMaxIdToParams(long maxId, RequestParams params) {
    if (maxId != Tweet.INVALID_TWEET_ID) {
      params.put("max_id", maxId);
    }

    return params;
  }

  private static RequestParams addCountToParams(int count, RequestParams params) {
    params.put("count", count);
    return params;
  }

  private static RequestParams addScreenNameToParams(String screenName, RequestParams params) {
    params.put("screen_name", screenName);
    return params;
  }
}