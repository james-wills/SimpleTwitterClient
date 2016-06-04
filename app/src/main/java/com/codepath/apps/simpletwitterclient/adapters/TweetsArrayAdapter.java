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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.activities.ProfileActivity;
import com.codepath.apps.simpletwitterclient.activities.TimelineActivity;
import com.codepath.apps.simpletwitterclient.models.MediaLink;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

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

    showTweetImages(viewHolder.llImages, tweet.getMedia());

    Glide.with(getContext())
        .load(tweet.getUser().getProfileImageUrl())
        .centerCrop()
        .bitmapTransform(new RoundedCornersTransformation(getContext(), 15, 15))
        .into(viewHolder.ivProfileImage);

    return convertView;
  }

  public void setOnProfileClickListener(OnProfileClickListener listener) {
    onProfileClickListener = listener;
  }

  private void showTweetImages(ViewGroup parent, List<MediaLink> media) {
    int childCount = parent.getChildCount();

    for (int i = 0; i < media.size(); i++) {
      ImageView iv;
      if (i > childCount - 1) {
        Log.d("DEBUG", "YEAHN BBABAY");
        iv = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.tweet_image, null);
        parent.addView(iv);
      } else {
        iv = (ImageView) parent.getChildAt(i);
      }

      iv.setVisibility(View.VISIBLE);
      iv.setImageResource(android.R.color.transparent);

      Glide.with(getContext())
          .load(media.get(i).getMediaUrl())
          .centerCrop()
          .bitmapTransform(new RoundedCornersTransformation(getContext(), 10, 15))
          .into(iv);
    }

    hideExcessImageViews(parent, media.size());
  }

  private void hideExcessImageViews(ViewGroup parent, int mediaCount) {
    for (int i = mediaCount; i < parent.getChildCount(); i++) {
      parent.getChildAt(i).setVisibility(View.GONE);
    }
  }

  private ImageView createTweetImageView() {
    Resources r = getContext().getResources();
    ImageView iv = new ImageView(getContext());
    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT, // width
        (int) r.getDimension(R.dimen.tweet_image_height) // height
    );

    lp.setMargins(
        (int) r.getDimension(R.dimen.zerodp), // left
        (int) r.getDimension(R.dimen.base_padding), // top
        (int) r.getDimension(R.dimen.zerodp), // right
        (int) r.getDimension(R.dimen.base_padding) // bottom
    );

    iv.setLayoutParams(lp);
    iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

    return iv;
  }

  public class ViewHolder {
    ImageView ivProfileImage;
    TextView tvScreenName;
    TextView tvName;
    TextView tvBody;
    TextView tvRetweetText;
    RelativeLayout rlRetweetLayout;
    LinearLayout llImages;

    public ViewHolder(View v) {
      this.ivProfileImage = (ImageView) v.findViewById(R.id.ivProfileImage);
      this.tvScreenName = (TextView) v.findViewById(R.id.tvScreenName);
      this.tvName = (TextView) v.findViewById(R.id.tvName);
      this.tvBody = (TextView) v.findViewById(R.id.tvTweetText);
      this.rlRetweetLayout = (RelativeLayout) v.findViewById(R.id.retweetLayout);
      this.tvRetweetText = (TextView) v.findViewById(R.id.tvRetweetText);
      this.llImages = (LinearLayout) v.findViewById(R.id.llImages);
    }
  }
}
