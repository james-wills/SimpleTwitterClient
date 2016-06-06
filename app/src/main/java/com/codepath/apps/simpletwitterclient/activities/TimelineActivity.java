package com.codepath.apps.simpletwitterclient.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.adapters.TabbedPagerAdapter;
import com.codepath.apps.simpletwitterclient.fragments.HomeTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.MentionsTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.TweetsListFragment;
import com.codepath.apps.simpletwitterclient.models.DetailUser;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterClient;
import com.codepath.apps.simpletwitterclient.adapters.TweetsArrayAdapter;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TimelineActivity extends CaligraphyActivity {
  @BindView(R.id.viewPagerHome) ViewPager viewPager;
  @BindView(R.id.tabStripHome) PagerSlidingTabStrip tabStrip;
  @BindView(R.id.toolbar) Toolbar toolbar;

  private HomeTimelineFragment homeTimelineFragment;
  private MentionsTimelineFragment mentionsTimelineFragment;

  MenuItem miActionProgressItem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timeline);
    ButterKnife.bind(this);

    setSupportActionBar(toolbar);

    TweetsArrayAdapter.OnProfileClickListener listener = new TweetsArrayAdapter.OnProfileClickListener() {
      @Override
      public void onClick(String screenName) {
        onClickProfile(screenName);
      }
    };

    homeTimelineFragment = new HomeTimelineFragment();
    mentionsTimelineFragment = new MentionsTimelineFragment();

    TabbedPagerAdapter pagerAdapter = new TabbedPagerAdapter(
        getSupportFragmentManager(),
        Arrays.asList("Home", "Mentions"),
        Arrays.asList((Fragment) homeTimelineFragment, mentionsTimelineFragment)
    );

    homeTimelineFragment.setOnProfileClickListener(listener);
    mentionsTimelineFragment.setOnProfileClickListener(listener);

    viewPager.setAdapter(pagerAdapter);

    tabStrip.setViewPager(viewPager);
  }

  @Override
  protected void onResume() {
    super.onResume();
    homeTimelineFragment.getFreshTimeline();
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    // Store instance of the menu item containing progress
    miActionProgressItem = menu.findItem(R.id.miActionProgress);
    // Extract the action-view from the menu item
    ProgressBar v =  (ProgressBar) MenuItemCompat.getActionView(miActionProgressItem);
    // Return to finish
    return super.onPrepareOptionsMenu(menu);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_timeline, menu);
    return true;
  }

  public void onProfileView(MenuItem mi) {
    if (TwitterApplication.currentUser == null) {
      Toast.makeText(this, "The user isn't available yet!", Toast.LENGTH_LONG);
      return;
    }

    Intent i = new Intent(TimelineActivity.this, ProfileActivity.class);
    i.putExtra("screen_name", TwitterApplication.currentUser.getScreenName());
    startActivity(i);
  }

  public void onCompose(MenuItem mi) {
    if (TwitterApplication.currentUser == null) {
      Toast.makeText(this, "The user isn't available yet!", Toast.LENGTH_LONG);
      return;
    }

    Intent i = new Intent(TimelineActivity.this, ComposeActivity.class);
    i.putExtra("profile_url", TwitterApplication.currentUser.getProfileImageUrl());
    startActivity(i);
  }

  public void showProgressBar() {
    miActionProgressItem.setVisible(true);
  }

  public void hideProgressBar() {
    miActionProgressItem.setVisible(false);
  }

  public void onClickProfile(String screenName) {
    Intent i = new Intent(TimelineActivity.this, ProfileActivity.class);
    i.putExtra("screen_name", screenName);
    startActivity(i);
  }
}
