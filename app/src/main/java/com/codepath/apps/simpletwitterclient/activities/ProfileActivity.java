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
import android.widget.FrameLayout;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.adapters.TweetsArrayAdapter;
import com.codepath.apps.simpletwitterclient.fragments.FavoritesTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.HomeTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.MentionsTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.ProfileHeaderFragment;
import com.codepath.apps.simpletwitterclient.fragments.UserTimelineFragment;
import com.codepath.apps.simpletwitterclient.models.User;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends CaligraphyActivity {
  private String screenName;
  @BindView(R.id.viewPagerProfile) ViewPager viewPager;
  @BindView(R.id.tabStripProfile) PagerSlidingTabStrip tabStrip;
  @BindView(R.id.profileToolbar) Toolbar toolbar;

  UserTimelineFragment userTimelineFragment;
  FavoritesTimelineFragment favoritesTimelineFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
    ButterKnife.bind(this);

    setSupportActionBar(toolbar);
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

    viewPager.setAdapter(new ProfilePagerAdapter(getSupportFragmentManager()));
    tabStrip.setViewPager(viewPager);
  }

  public void onClickProfile(String screenName) {
    Log.d("JB", "clicked profile");
    if (TwitterApplication.currentUser != null &&
        screenName.equals(TwitterApplication.currentUser.getScreenName())) {
      return;
    }
    Log.d("JB", "starting profile intent");

    Intent i = new Intent(ProfileActivity.this, ProfileActivity.class);
    i.putExtra("screen_name", screenName);
    startActivity(i);
  }

  public class ProfilePagerAdapter extends FragmentPagerAdapter {
    private String[] tabTitles = { "Tweets", "Favorites" };

    public ProfilePagerAdapter(FragmentManager f) {
      super(f);
    }

    @Override
    public Fragment getItem(int position) {
      switch(position) {
        case 0:
          return UserTimelineFragment.newInstance(screenName);
        case 1:
          return FavoritesTimelineFragment.newInstance(screenName);
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
