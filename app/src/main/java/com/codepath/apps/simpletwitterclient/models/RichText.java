package com.codepath.apps.simpletwitterclient.models;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;

import com.codepath.apps.simpletwitterclient.utils.URLSpanNoUnderline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by james_wills on 6/2/16.
 */
public class RichText {
  String baseText;
  List<Mention> mentions;
  List<Hashtag> hashtags;
  List<TextUrl> urls;
  Spannable stringHtml;

  public String getBaseText() {
    return baseText;
  }

  public List<Mention> getMentions() {
    return mentions;
  }

  public List<Hashtag> getHashtags() {
    return hashtags;
  }

  public List<TextUrl> getUrls() {
    return urls;
  }

  public RichText() {
    this.baseText = "";
    this.mentions = new ArrayList<>();
    this.hashtags = new ArrayList<>();
    this.urls = new ArrayList<>();
  }

  public RichText(String baseText, List<TextUrl> urls) {
    this();

    this.baseText = baseText;
    this.urls = urls;
  }

  public RichText(String baseText, List<Mention> mentions, List<Hashtag> hashtags, List<TextUrl> urls, List<MediaLink> media) {
    this.baseText = baseText;
    this.mentions = mentions;
    this.hashtags = hashtags;
    this.urls = urls;
    this.stringHtml = createStringHTML(media);
  }

  public Spannable getStringHtml() {
    return stringHtml;
  }

  private Spannable createStringHTML(List<MediaLink> media) {
    if (baseText.length() == 0) {
      return URLSpanNoUnderline.getSpannable("");
    }

    List<Link> links = new ArrayList<>();
    links.addAll(mentions);
    links.addAll(hashtags);
    links.addAll(urls);
    links.addAll(media);
    Collections.sort(links);
    List<String> splitString = new ArrayList<>();
    int lastIndex = 0;
    for (Link l : links) {
      Log.d("SUBSTRING", String.format("last: %d, start: %d, end: %d\noriginal: %s", lastIndex, l.startIndex, l.endIndex, baseText));
      splitString.add(baseText.substring(lastIndex, l.startIndex));
      splitString.add(baseText.substring(l.startIndex, l.endIndex));
      lastIndex = l.endIndex;
    }

    splitString.add(baseText.substring(lastIndex));

    String result = "";
    int linkIndex = 0;
    for (int i = 0; i < splitString.size(); i++) {
      boolean isLink = i % 2 != 0;
      if (isLink) {
        Link item = links.get(linkIndex);
        if (!(item instanceof MediaLink)) {
          result += String.format("<a href=\"%s\">%s</a>", item.getLink(), item.getDisplayLink());
        }
        linkIndex++;
      } else {
        result += splitString.get(i);
      }
    }

    return URLSpanNoUnderline.getSpannable(result);
  }

  public String toString() {
    return baseText;
  }
}
