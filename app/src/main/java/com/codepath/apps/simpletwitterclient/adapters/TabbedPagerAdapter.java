package com.codepath.apps.simpletwitterclient.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codepath.apps.simpletwitterclient.fragments.FavoritesTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.UserTimelineFragment;

import java.util.List;

/**
 * Created by james_wills on 6/4/16.
 */
public class TabbedPagerAdapter extends FragmentPagerAdapter {
  private List<String> tabTitles;
  private List<Fragment> fragments;

  public TabbedPagerAdapter(FragmentManager f, List<String> tabTitles, List<Fragment> fragments) {
    super(f);
    this.tabTitles = tabTitles;
    this.fragments = fragments;
  }

  @Override
  public Fragment getItem(int position) {
    return fragments.get(position);
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return tabTitles.get(position);
  }

  @Override
  public int getCount() {
    return tabTitles.size();
  }
}