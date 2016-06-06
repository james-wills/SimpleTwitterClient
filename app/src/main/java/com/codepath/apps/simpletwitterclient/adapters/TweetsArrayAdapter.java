package com.codepath.apps.simpletwitterclient.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.activities.ProfileActivity;
import com.codepath.apps.simpletwitterclient.activities.TimelineActivity;
import com.codepath.apps.simpletwitterclient.models.MediaLink;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;
import com.codepath.apps.simpletwitterclient.utils.TimeUtil;

import java.lang.annotation.Target;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

/**
 * Created by james_wills on 6/1/16.
 */
public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {
  public interface OnProfileClickListener {
    public void onClick(String screenName);
  }

  public interface OnTweetClickListener {
    public void onClick(long tweetId);
  }

  public TweetsArrayAdapter(Context c, List<Tweet> tweets) {
    super(c, android.R.layout.simple_list_item_1, tweets);
  }

  private OnProfileClickListener onProfileClickListener;
  private OnTweetClickListener onTweetClickListener;

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    Log.d("POSITION", position + "");

    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet, parent, false);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    final Tweet tweet;
    if (getItem(position).getRetweetedStatus() != null) {
      viewHolder.rlRetweetLayout.setVisibility(View.VISIBLE);
      viewHolder.tvRetweetText.setText(String.format(getContext().getString(R.string.retweeted_by), getItem(position).getUser().getName()));
      tweet = getItem(position).getRetweetedStatus();
    } else {
      viewHolder.rlRetweetLayout.setVisibility(View.GONE);
      tweet = getItem(position);
    }

    viewHolder.tvName.setText(tweet.getUser().getName());
    viewHolder.tvScreenName.setText(tweet.getUser().getScreenName());
    viewHolder.tvBody.setText(tweet.getTweetText().getStringHtml());

    viewHolder.ivProfileImage.setImageResource(android.R.color.transparent);

    viewHolder.ivProfileImage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String screenName = tweet.getUser().getScreenName();
        if (onProfileClickListener != null) {
          onProfileClickListener.onClick(screenName);
        }
      }
    });

    String timeText;

    try {
      timeText = tweet.getTimeSinceCreation();
    } catch (ParseException e) {
      timeText = "";
    }

    viewHolder.tvDateCreated.setText(timeText);

    setTweetImages(viewHolder, tweet.getMedia());

    Glide.with(getContext())
        .load(tweet.getUser().getProfileImageUrl())
        .bitmapTransform(
            new CenterCrop(getContext()),
            new RoundedCornersTransformation(getContext(), 15, 0)
        )
        .into(viewHolder.ivProfileImage);

    return convertView;
  }

  public void setOnProfileClickListener(OnProfileClickListener listener) {
    onProfileClickListener = listener;
  }

  private void setTweetImages(ViewHolder vh, List<MediaLink> media) {
    // Currently twitter only allows 4 images per tweet, but that may change in the future
    int numImages = Math.min(media.size(), 4);

    List<ImageView> tweetImageViews = vh.getTweetImageViews(numImages);

    for (int i = 0; i < numImages; i++) {
      ImageView iv = tweetImageViews.get(i);
      iv.setImageResource(android.R.color.transparent);
      MediaLink link = media.get(i);

      Glide.with(getContext())
          .load(link.getMediaUrl())
          .bitmapTransform(
              new CenterCrop(getContext()),
              new RoundedCornersTransformation(getContext(), 15, 0, cornersToRound(iv))
          ).into(iv);
    }

    hideExcessImageLayouts(vh, media.size());
  }

  private CornerType cornersToRound(ImageView v) {
    String tag = (String) v.getTag();
    Context c = getContext();

    if (tag.equals(c.getString(R.string.top))) {
      return CornerType.TOP;
    } else if (tag.equals(c.getString(R.string.bottom))) {
      return CornerType.BOTTOM;
    } else if (tag.equals(c.getString(R.string.left))) {
      return CornerType.LEFT;
    } else if (tag.equals(c.getString(R.string.right))) {
      return CornerType.RIGHT;
    } else if (tag.equals(c.getString(R.string.top_left))) {
      return CornerType.TOP_LEFT;
    } else if (tag.equals(c.getString(R.string.top_right))) {
      return CornerType.TOP_RIGHT;
    } else if (tag.equals(c.getString(R.string.bottom_left))) {
      return CornerType.BOTTOM_LEFT;
    } else if (tag.equals(c.getString(R.string.bottom_right))) {
      return CornerType.BOTTOM_RIGHT;
    } else {
      return CornerType.ALL;
    }
  }

  private void hideExcessImageLayouts(ViewHolder vh, int mediaCount) {
    if (mediaCount == 0) {
      vh.flTweetImages.setVisibility(View.GONE);
    } else {
      vh.flTweetImages.setVisibility(View.VISIBLE);
    }

    List<ViewGroup> layouts = vh.imageViewLayouts;
    for (int i = 0; i < layouts.size(); i++) {
      if (i + 1 == mediaCount) {
        layouts.get(i).setVisibility(View.VISIBLE);
      } else {
        layouts.get(i).setVisibility(View.GONE);
      }
    }
  }

  public class ViewHolder {
    @BindView(R.id.ivProfileImage) ImageView ivProfileImage;
    @BindView(R.id.tvScreenName) TextView tvScreenName;
    @BindView(R.id.tvName) TextView tvName;
    @BindView(R.id.tvTweetText) TextView tvBody;
    @BindView(R.id.tvRetweetText) TextView tvRetweetText;
    @BindView(R.id.retweetLayout) RelativeLayout rlRetweetLayout;
    @BindView(R.id.flTweetImages) FrameLayout flTweetImages;
    @BindView(R.id.tvDateCreated) TextView tvDateCreated;

    List<ViewGroup> imageViewLayouts;
    private List<List<ImageView>> tweetImageViews;

    public ViewHolder(View v) {
      ButterKnife.bind(this, v);

      tweetImageViews = new ArrayList<>();
      tweetImageViews.add(new ArrayList<ImageView>());
      imageViewLayouts = new ArrayList<>();
      for (int viewGroupIndex = 0; viewGroupIndex < flTweetImages.getChildCount(); viewGroupIndex++) {
        ViewGroup imageLayout = (ViewGroup) flTweetImages.getChildAt(viewGroupIndex);
        imageViewLayouts.add(imageLayout);

        List<ImageView> ivList = new ArrayList<>();
        for (int ivIndex = 0; ivIndex < imageLayout.getChildCount(); ivIndex++) {
          ivList.add((ImageView) imageLayout.getChildAt(ivIndex));
        }

        tweetImageViews.add(ivList);
      }
    }

    public List<ImageView> getTweetImageViews(int numImages) {
      return tweetImageViews.get(numImages);
    }
  }
}
