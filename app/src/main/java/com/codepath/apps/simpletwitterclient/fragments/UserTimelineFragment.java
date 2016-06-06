package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class UserTimelineFragment extends TweetsListFragment {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public static UserTimelineFragment newInstance(String screenName) {
    UserTimelineFragment userFragment = new UserTimelineFragment();
    Bundle args = new Bundle();
    args.putString("screen_name", screenName);
    userFragment.setArguments(args);
    return userFragment;
  }

  public void populateTimeline(long maxId) {
    String screenName = getArguments().getString("screen_name");
    client.getUserTimeline(screenName, maxId, new TweetResponseHandler());
  }
}
