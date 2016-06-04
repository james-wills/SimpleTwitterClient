package com.codepath.apps.simpletwitterclient.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.simpletwitterclient.R;
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

    homeTimelineFragment.setOnProfileClickListener(listener);
    mentionsTimelineFragment.setOnProfileClickListener(listener);

    viewPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));
    tabStrip.setViewPager(viewPager);
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

  }

  public void onClickProfile(String screenName) {
    Intent i = new Intent(TimelineActivity.this, ProfileActivity.class);
    i.putExtra("screen_name", screenName);
    startActivity(i);
  }

  public class TweetsPagerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = { "Home", "Mentions" };

    public TweetsPagerAdapter(FragmentManager f) {
      super(f);
    }

    @Override
    public Fragment getItem(int position) {
      switch(position) {
        case 0:
          return homeTimelineFragment;
        case 1:
          return mentionsTimelineFragment;
        default:
          return null;
      }
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return tabTitles[position];
    }

    @Override
    public int getCount() {
      return tabTitles.length;
    }
  }
}
