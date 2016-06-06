package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class HomeTimelineFragment extends TweetsListFragment {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public void populateTimeline(long maxId) {
    client.getHomeTimeline(maxId, new TweetResponseHandler());
  }
}
