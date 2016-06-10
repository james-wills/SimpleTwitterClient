package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by james_wills on 6/2/16.
 */
public class FavoritesTimelineFragment extends TweetsListFragment {

  public static FavoritesTimelineFragment newInstance(String screenName) {
    FavoritesTimelineFragment favoriteFragment = new FavoritesTimelineFragment();
    Bundle args = new Bundle();
    args.putString("screen_name", screenName);
    favoriteFragment.setArguments(args);
    return favoriteFragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  public void populateTimeline(long maxId) {
    String screenName = getArguments().getString("screen_name");
    client.getFavoritesTimeline(screenName, maxId, new TweetResponseHandler());
  }
}
