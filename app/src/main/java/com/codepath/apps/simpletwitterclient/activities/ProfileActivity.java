package com.codepath.apps.simpletwitterclient.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.adapters.TabbedPagerAdapter;
import com.codepath.apps.simpletwitterclient.adapters.TweetsArrayAdapter;
import com.codepath.apps.simpletwitterclient.fragments.FavoritesTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.HomeTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.MentionsTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.ProfileHeaderFragment;
import com.codepath.apps.simpletwitterclient.fragments.UserTimelineFragment;
import com.codepath.apps.simpletwitterclient.models.User;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends CaligraphyActivity {

  private String screenName;
  @BindView(R.id.viewPagerProfile) ViewPager viewPager;
  @BindView(R.id.tabStripProfile) PagerSlidingTabStrip tabStrip;

  UserTimelineFragment userTimelineFragment;
  FavoritesTimelineFragment favoritesTimelineFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
    ButterKnife.bind(this);

    screenName = getIntent().getStringExtra("screen_name");

    TweetsArrayAdapter.OnProfileClickListener listener = new TweetsArrayAdapter.OnProfileClickListener() {
      @Override
      public void onClick(String screenName) {
        onClickProfile(screenName);
      }
    };

    userTimelineFragment = UserTimelineFragment.newInstance(screenName);
    favoritesTimelineFragment = FavoritesTimelineFragment.newInstance(screenName);

    userTimelineFragment.setOnProfileClickListener(listener);
    favoritesTimelineFragment.setOnProfileClickListener(listener);

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.headerFragmentLayout, ProfileHeaderFragment.newInstance(screenName));
    ft.commit();

    TabbedPagerAdapter pagerAdapter = new TabbedPagerAdapter(
        getSupportFragmentManager(),
        Arrays.asList("Tweets", "Favorites"),
        Arrays.asList((Fragment) userTimelineFragment, favoritesTimelineFragment)
    );

    viewPager.setAdapter(pagerAdapter);
    tabStrip.setViewPager(viewPager);
  }


  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    /*
      This fixes null point exception on certain scroll actions.
      https://code.google.com/p/android/issues/detail?id=183166
     */
    try {
      return super.dispatchTouchEvent(ev);
    } catch (Exception e) {
      return false;
    }
  }

  public void onClickProfile(String screenName) {
    if (TwitterApplication.currentUser != null &&
        screenName.equals(TwitterApplication.currentUser.getScreenName())) {
      return;
    }

    Intent i = new Intent(ProfileActivity.this, ProfileActivity.class);
    i.putExtra("screen_name", screenName);
    startActivity(i);
  }
}
