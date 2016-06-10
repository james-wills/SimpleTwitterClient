package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by james_wills on 6/2/16.
 */
public class UserTimelineFragment extends TweetsListFragment {

  public static UserTimelineFragment newInstance(String screenName) {
    UserTimelineFragment userFragment = new UserTimelineFragment();
    Bundle args = new Bundle();
    args.putString("screen_name", screenName);
    userFragment.setArguments(args);
    return userFragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public void populateTimeline(long maxId) {
    String screenName = getArguments().getString("screen_name");
    client.getUserTimeline(screenName, maxId, new TweetResponseHandler());
  }
}
