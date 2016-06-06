package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.adapters.TweetsArrayAdapter;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterClient;
import com.codepath.apps.simpletwitterclient.utils.EndlessScrollListener;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;

/**
 * Created by james_wills on 6/1/16.
 */
public abstract class TweetsListFragment extends Fragment {
  public abstract void populateTimeline(long maxId);

  @BindView(R.id.lvTweets) ListView lvTweets;
  @BindView(R.id.swipeContainer) SwipeRefreshLayout swipeContainer;

  private TweetsArrayAdapter adapter;
  private ArrayList<Tweet> tweets;

  public static final TwitterClient client = TwitterApplication.getRestClient();;

  private TweetsArrayAdapter.OnProfileClickListener profileClickListener;

  private long lastRequestMaxId = Tweet.INVALID_TWEET_ID;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_tweets, container, false);
    ButterKnife.bind(this, v);

    lvTweets.setAdapter(adapter);
    lvTweets.setOnScrollListener(new EndlessScrollListener() {
      @Override
      public boolean onLoadMore(int page, int totalItemsCount) {
        populateTimelineAndStoreQuery(getMaxId());
        return true;
      }
    });

    ViewCompat.setNestedScrollingEnabled(lvTweets, true);

    swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        getFreshTimeline();
      }
    });

    return v;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    tweets = new ArrayList<>();
    adapter = new TweetsArrayAdapter(getActivity(), tweets);
    adapter.setOnProfileClickListener(profileClickListener);

    getFreshTimeline();

    super.onCreate(savedInstanceState);
  }

  public void setOnProfileClickListener(TweetsArrayAdapter.OnProfileClickListener listener) {
    this.profileClickListener = listener;
  }

  public void addAll(List<Tweet> tweets) {
    adapter.addAll(tweets);
    adapter.notifyDataSetChanged();
  }

  public void scrollToTop() {
    lvTweets.setSelectionAfterHeaderView();
  }

  public long getMaxId() {
    return adapter.getItem(adapter.getCount() - 1).getTweetId();
  }

  public void getFreshTimeline() {
    if (adapter == null) {
      return;
    }

    adapter.clear();
    populateTimelineAndStoreQuery(Tweet.INVALID_TWEET_ID);
  }

  public void onTimeLinePopulated() {
    swipeContainer.setRefreshing(false);
  }

  public void populateTimelineAndStoreQuery(long maxId) {
    if (swipeContainer != null) {
      swipeContainer.setRefreshing(true);
    }

    lastRequestMaxId = maxId;

    populateTimeline(maxId);
  }

  public void retryLastRequest() {
    populateTimelineAndStoreQuery(lastRequestMaxId);
  }

  public class TweetResponseHandler extends JsonHttpResponseHandler {
    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
      addAll(Tweet.fromJSONArray(response));
      onTimeLinePopulated();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
      View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          retryLastRequest();
        }
      };

      Snackbar.make(lvTweets, R.string.error_loading_tweets, Snackbar.LENGTH_INDEFINITE)
          .setAction("Retry", listener)
          .show();

      onTimeLinePopulated();
    }
  }
}
