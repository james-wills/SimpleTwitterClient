package com.codepath.apps.simpletwitterclient.fragments;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.models.DetailUser;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.msebera.android.httpclient.Header;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by james_wills on 6/2/16.
 */
public class ProfileHeaderFragment extends Fragment {
  @BindView(R.id.tvBio) TextView tvBio;
  @BindView(R.id.tvLocation) TextView tvLocation;
  @BindView(R.id.tvProfileScreenName) TextView tvProfileScreenName;
  @BindView(R.id.tvProfileName) TextView tvProfileName;
  @BindView(R.id.tvURL) TextView tvURL;
  @BindView(R.id.ivBannerImage) ImageView ivBannerImage;
  @BindView(R.id.ivUserAvi) ImageView ivUserAvi;
  @BindView(R.id.ivLinkIcon) ImageView ivLinkIcon;
  @BindView(R.id.ivLocationIcon) ImageView ivLocationIcon;
  @BindView(R.id.tvFollowersCount) TextView tvFollowersCount;
  @BindView(R.id.tvFriendsCount) TextView tvFriendsCount;

  private TwitterClient client;
  private DetailUser user;
  String screenName;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_profile_header, container, false);
    ButterKnife.bind(this, view);

    screenName = getArguments().getString("screen_name");

    client = TwitterApplication.getRestClient();
    client.getUserInfo(screenName, new JsonHttpResponseHandler() {
      @Override
      public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
        user = new DetailUser(response);
        populateHeader();
      }

      @Override
      public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
        Log.d("DEBUG", "Failed to get user info");
      }
    });

    return view;
  }

  private void populateHeader() {
    tvBio.setText(user.getDescription().getStringHtml());
    Log.i("JBUSERACTUAL", user.getDescription() + "");
    showOrHideView(tvBio, user.hasDescription());

    tvLocation.setText(user.getLocation());
    showOrHideView(tvLocation, user.hasLocation());
    showOrHideView(ivLocationIcon, user.hasLocation());

    tvURL.setText(user.getUrl().getStringHtml());
    showOrHideView(tvURL, user.hasUrl());
    showOrHideView(ivLinkIcon, user.hasUrl());

    tvProfileName.setText(user.getName());
    tvProfileScreenName.setText(user.getScreenName());

    tvFriendsCount.setText(user.getFriendsCount() + "");
    tvFollowersCount.setText(user.getFollowerCount() + "");

    Glide.with(getContext())
        .load(user.getProfileImageUrl())
        .centerCrop()
        .bitmapTransform(new RoundedCornersTransformation(getContext(), 15, 15))
        .placeholder(R.drawable.avi_placeholder)
        .into(ivUserAvi);

    Glide.with(getContext())
        .load(user.getBannerImageUrl())
        .placeholder(R.drawable.banner_placeholder)
        .into(ivBannerImage);
  }

  private static void showOrHideView(View v, boolean shouldShow) {
    if (shouldShow) {
      v.setVisibility(View.VISIBLE);
    } else {
      v.setVisibility(View.GONE);
    }
  }

  public static ProfileHeaderFragment newInstance(String screenName) {
    ProfileHeaderFragment headerFragment = new ProfileHeaderFragment();
    Bundle args = new Bundle();
    args.putString("screen_name", screenName);
    headerFragment.setArguments(args);
    return headerFragment;
  }
}
