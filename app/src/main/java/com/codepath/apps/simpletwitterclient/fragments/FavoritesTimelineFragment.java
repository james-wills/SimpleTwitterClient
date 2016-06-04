package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by james_wills on 6/2/16.
 */
public class FavoritesTimelineFragment  extends TweetsListFragment {
  private TwitterClient client;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    client = TwitterApplication.getRestClient();
    populateTimeline();
  }

  public static FavoritesTimelineFragment newInstance(String screenName) {
    FavoritesTimelineFragment favoriteFragment = new FavoritesTimelineFragment();
    Bundle args = new Bundle();
    args.putString("screen_name", screenName);
    favoriteFragment.setArguments(args);
    return favoriteFragment;
  }

  private void populateTimeline() {
    String screenName = getArguments().getString("screen_name");
    client.getFavoritesTimeline(screenName, new JsonHttpResponseHandler() {
      @Override
      public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
        Log.d("DEBUG", response.toString());
        addAll(Tweet.fromJSONArray(response));
      }

      @Override
      public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        Log.d("DEBUG", errorResponse.toString());
      }
    });
  }
}
