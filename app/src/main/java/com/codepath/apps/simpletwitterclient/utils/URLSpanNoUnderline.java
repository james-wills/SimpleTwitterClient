package com.codepath.apps.simpletwitterclient.utils;

import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.URLSpan;

import android.text.TextPaint;
import android.text.style.URLSpan;

// From https://prativas.wordpress.com/2013/05/20/hyperlinktextcolor/
public class URLSpanNoUnderline extends URLSpan {
  public URLSpanNoUnderline(String p_Url) {
    super(p_Url);
  }

  public void updateDrawState(TextPaint p_DrawState) {
    super.updateDrawState(p_DrawState);
    p_DrawState.setUnderlineText(false);
  }

  public static Spannable getSpannable(String text) {
    Spannable p_Text = Spannable.Factory.getInstance().newSpannable(
        Html.fromHtml(text));

    URLSpan[] spans = p_Text.getSpans(0, p_Text.length(), URLSpan.class);
    for (URLSpan span : spans) {
      int start = p_Text.getSpanStart(span);
      int end = p_Text.getSpanEnd(span);
      p_Text.removeSpan(span);
      span = new URLSpanNoUnderline(span.getURL());
      p_Text.setSpan(span, start, end, 0);
    }
    return p_Text;
  }
}