package com.codepath.apps.simpletwitterclient.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.fragments.ComposeFragment;

public class ComposeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_compose);

    String url = getIntent().getStringExtra("profile_url");

    ComposeFragment composeFragment = ComposeFragment.newInstance(url);

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.composeFragmentLayout, composeFragment);
    ft.commit();


    composeFragment.setComposeListener(new ComposeFragment.ComposeListener() {
      @Override
      public void onTweetSent() {
        finish();
      }

      @Override
      public void onCancel() {
        finish();
      }
    });
  }
}
