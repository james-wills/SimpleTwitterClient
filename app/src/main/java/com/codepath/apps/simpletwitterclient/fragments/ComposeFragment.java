package com.codepath.apps.simpletwitterclient.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterApplication;
import com.codepath.apps.simpletwitterclient.twitterapi.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import cz.msebera.android.httpclient.Header;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by james_wills on 6/5/16.
 */
public class ComposeFragment extends Fragment {
  public interface ComposeListener {
    public void onTweetSent();
    public void onCancel();
  }

  @BindView(R.id.tvCharacterCount) TextView tvCharacterCount;
  @BindView(R.id.tvCancelText) TextView tvCancelText;
  @BindView(R.id.ivAvi) ImageView ivAvi;
  @BindView(R.id.etTweetText) EditText etTweetText;
  @BindView(R.id.btnTweet) Button btnTweet;

  private TwitterClient client;
  private ComposeListener listener;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_compose, container, false);
    ButterKnife.bind(this, view);

    String profileImageUrl = getArguments().getString("profile_url");

    Glide.with(getContext()).load(profileImageUrl)
        .bitmapTransform(new CenterCrop(getContext()), new RoundedCornersTransformation(getContext(), 10, 0))
        .into(ivAvi);

    client = TwitterApplication.getRestClient();

    enableTweetButton(isValidTweet());

    return view;
  }

  @OnClick(R.id.btnTweet)
  public void onTweetClicked() {
    if (isValidTweet()) {
      client.postTweet(getTweetText(), new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
          if (listener != null) {
            listener.onTweetSent();
          }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
          try {
            Log.d("DEBUG", errorResponse.toString(2));
          } catch (JSONException e) {
            Log.d("DEBUG", errorResponse.toString());
          }
          onTweetFailedToSend();
        }
      });
    }
  }

  @OnClick(R.id.tvCancelText)
  public void onCancelClicked() {
    if (listener != null) {
      listener.onCancel();
    }
  }

  @OnTextChanged(R.id.etTweetText)
  public void onTextChanged() {
    updateCharacterCount();
    enableTweetButton(isValidTweet());
  }

  private void onTweetFailedToSend() {
    Snackbar.make(etTweetText, "Tweet failed to send.", Snackbar.LENGTH_INDEFINITE)
        .setAction("Try again", new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            onTweetClicked();
          }
        }).show();
  }

  private String getTweetText() {
    return etTweetText.getText().toString();
  }

  private void updateCharacterCount() {
    int charactersLeft = Tweet.MAX_CHARACTERS - getTweetText().length();
    tvCharacterCount.setText("" + charactersLeft);

    if (charactersLeft < 0) {
      tvCharacterCount.setTextColor(getResources().getColor(R.color.error_text));
    } else if (charactersLeft < 10) {
      tvCharacterCount.setTextColor(getResources().getColor(R.color.warning_text));
    } else {
      tvCharacterCount.setTextColor(getResources().getColor(R.color.primary_text));
    }
  }

  private void enableTweetButton(boolean enabled) {
    btnTweet.setEnabled(enabled);

    if (enabled) {
      btnTweet.setBackgroundColor(getResources().getColor(R.color.primary_dark));
    } else {
      btnTweet.setBackgroundColor(getResources().getColor(R.color.primary_light));
    }
  }

  public void setComposeListener(ComposeListener listener) {
    this.listener = listener;
  }

  private boolean isValidTweet() {
    int tweetLength = getTweetText().length();
    return tweetLength > 0 && tweetLength < Tweet.MAX_CHARACTERS;
  }

  public static ComposeFragment newInstance(String profileImageUrl) {
    ComposeFragment headerFragment = new ComposeFragment();
    Bundle args = new Bundle();
    args.putString("profile_url", profileImageUrl);
    headerFragment.setArguments(args);
    return headerFragment;
  }
}
