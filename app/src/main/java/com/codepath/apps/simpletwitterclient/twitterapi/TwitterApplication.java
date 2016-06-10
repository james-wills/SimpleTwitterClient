package com.codepath.apps.simpletwitterclient.twitterapi;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.request.target.ViewTarget;
import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     TwitterClient client = TwitterApplication.getRestClient();
 *     // use client to send requests to API
 *
 */
public class TwitterApplication extends com.activeandroid.app.Application {
	private static Context context;
	private static TwitterClient client;
	public static User currentUser;

	@Override
	public void onCreate() {
		super.onCreate();
		TwitterApplication.context = this;
		CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
				.setDefaultFontPath("fonts/Roboto-Light.ttf")
				.setFontAttrId(R.attr.fontPath)
				.build()
		);

		ViewTarget.setTagId(R.id.glide_tag);

		client = (TwitterClient) TwitterClient.getInstance(TwitterClient.class, TwitterApplication.context);

		if (client.isAuthenticated()) {
			client.getCurrentUser(new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
					try {
						currentUser = User.CREATOR.parse(response);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

				@Override
				public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
					Log.d("DEBUG", errorResponse.toString());
				}
			});
		}

	}

	public static TwitterClient getRestClient() {
		return (TwitterClient) TwitterClient.getInstance(TwitterClient.class, TwitterApplication.context);
	}
}