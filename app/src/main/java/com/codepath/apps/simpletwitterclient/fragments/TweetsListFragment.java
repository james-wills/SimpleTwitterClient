package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.adapters.TweetsArrayAdapter;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by james_wills on 6/1/16.
 */
public class TweetsListFragment extends Fragment {
  private TweetsArrayAdapter adapter;
  private ArrayList<Tweet> tweets;
  private ListView lvTweets;

  private TweetsArrayAdapter.OnProfileClickListener listener;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_tweets, container, false);
    lvTweets = (ListView) v.findViewById(R.id.lvTweets);
    lvTweets.setAdapter(adapter);
    return v;
  }

  public TweetsArrayAdapter getAdapter() {
    return adapter;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    tweets = new ArrayList<>();
    adapter = new TweetsArrayAdapter(getActivity(), tweets);
    adapter.setOnProfileClickListener(listener);

    super.onCreate(savedInstanceState);
  }

  public void setOnProfileClickListener(TweetsArrayAdapter.OnProfileClickListener listener) {
    this.listener = listener;
  }

  public void addAll(List<Tweet> tweets) {
    adapter.addAll(tweets);
  }
}
