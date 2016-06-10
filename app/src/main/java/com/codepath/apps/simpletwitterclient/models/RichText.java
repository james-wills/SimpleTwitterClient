package com.codepath.apps.simpletwitterclient.models;

import android.text.Spannable;

import com.codepath.apps.simpletwitterclient.utils.URLSpanNoUnderline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by james_wills on 6/8/16.
 */
public class RichText {
  final String baseText;
  List<MentionEntity> mentions;
  List<HashtagEntity> hashtags;
  List<UrlEntity> urls;
  List<MediaEntity> media;
  Spannable stringHtml;

  public RichText(String baseText,
                  List<MentionEntity> mentions,
                  List<HashtagEntity> hashtags,
                  List<UrlEntity> urls,
                  List<MediaEntity> media) {
    if (baseText != null) {
      this.baseText = baseText;
    } else {
      this.baseText = "";
    }

    this.mentions = mentions;
    this.hashtags = hashtags;
    this.urls = urls;
    this.media = media;
    this.stringHtml = createStringHtml();
  }

  public RichText(String baseText, List<UrlEntity> urls) {
    this(baseText,
        new ArrayList<MentionEntity>(),
        new ArrayList<HashtagEntity>(),
        urls,
        new ArrayList<MediaEntity>());
  }

  public RichText(String baseText) {
    this(baseText, new ArrayList<UrlEntity>());
  }

  public String getBaseText() {
    return baseText;
  }

  public List<MentionEntity> getMentions() {
    return mentions;
  }

  public List<HashtagEntity> getHashtags() {
    return hashtags;
  }

  public List<UrlEntity> getUrls() {
    return urls;
  }

  public Spannable getStringHtml() {
    return stringHtml;
  }

  private Spannable createStringHtml() {
    if (baseText == null || baseText.length() == 0) {
      return URLSpanNoUnderline.getSpannable("");
    }

    List<Entity> entities = getEntities();
    if (entities.size() == 0) {
      return URLSpanNoUnderline.getSpannable(baseText);
    }

    List<String> splitString = new ArrayList<>();
    int lastIndex = 0;
    for (Entity e : entities) {
      splitString.add(baseText.substring(lastIndex, e.getStart()));
      splitString.add(baseText.substring(e.getStart(), e.getEnd()));
      lastIndex = e.getEnd();
    }

    splitString.add(baseText.substring(lastIndex));

    String result = "";
    int linkIndex = 0;
    for (int i = 0; i < splitString.size(); i++) {
      boolean isEntity = i % 2 != 0;
      if (isEntity) {
        Entity item = entities.get(linkIndex);
        if (!(item instanceof MediaEntity)) {
          result += String.format("<a href=\"%s\">%s</a>", item.getLink(), item.getDisplayLink());
        }
        linkIndex++;
      } else {
        result += splitString.get(i);
      }
    }

    return URLSpanNoUnderline.getSpannable(result);
  }

  public List<Entity> getEntities() {
    List<Entity> links = new ArrayList<>();
    links.addAll(mentions);
    links.addAll(hashtags);
    links.addAll(urls);
    links.addAll(media);

    Collections.sort(links, new Comparator<Entity>() {
      @Override
      public int compare(Entity lhs, Entity rhs) {
        return lhs.getStart() - rhs.getStart();
      }
    });

    return links;
  }
}
