package com.codepath.apps.simpletwitterclient.models;

import android.text.Spannable;

import com.codepath.apps.simpletwitterclient.utils.URLSpanNoUnderline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by james_wills on 6/2/16.
 */
public class RichText {
  final String baseText;
  List<Mention> mentions;
  List<Hashtag> hashtags;
  List<TextUrl> urls;
  Spannable stringHtml;

  public String getBaseText() {
    return baseText;
  }

  public RichText() {
    this("", new ArrayList<Mention>(), new ArrayList<Hashtag>(), new ArrayList<TextUrl>(), new ArrayList<MediaLink>());
  }

  public RichText(String baseText, List<TextUrl> urls) {
    this(baseText, new ArrayList<Mention>(), new ArrayList<Hashtag>(), urls, new ArrayList<MediaLink>());
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

    List<Link> links = getLinks(media);
    if (links.size() == 0) {
      return URLSpanNoUnderline.getSpannable(baseText);
    }

    List<String> splitString = new ArrayList<>();
    int lastIndex = 0;
    for (Link l : links) {
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

  public List<Link> getLinks(List<MediaLink> mediaLinks) {
    List<Link> links = new ArrayList<>();
    links.addAll(mentions);
    links.addAll(hashtags);
    links.addAll(urls);
    links.addAll(mediaLinks);
    Collections.sort(links);
    return links;
  }

  public String toString() {
    String s = "RICHTEXT: " + baseText;
    for (Mention m : mentions) {
      s += "MENTION:\n" + m + "\n";
    }

    for (TextUrl t : urls) {
      s += "URL:\n" + t + "\n";
    }

    for (Hashtag h : hashtags) {
      s += "HASHTAG:\n" + h + "\n";
    }

    s += "\nEND_RICHTEXT\n\n\n";
    return s;
  }
}
