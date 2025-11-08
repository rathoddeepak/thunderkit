package com.thunderkit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import androidx.core.graphics.ColorUtils;

import com.thunderkit.theme.ColorId;
import com.thunderkit.theme.Theme;
import com.thunderkit.tool.Paints;

public class LickView extends View {
  public LickView (Context context) {
    super(context);
  }

  private float factor;
  private int headerBackground;

  public void setHeaderBackground (int headerBackground) {
    this.headerBackground = headerBackground;
    invalidate();
  }

  public float getFactor () {
    return factor;
  }

  public void setFactor (float factor) {
    if (this.factor != factor) {
      this.factor = factor;
      invalidate();
    }
  }

  @Override
  protected void onDraw (Canvas c) {
    if (factor > 0f) {
      int bottom = getMeasuredHeight();
      int top = bottom - (int) ((float) bottom * factor);
      c.drawRect(0, top, getMeasuredWidth(), bottom, Paints.fillingPaint(
        ColorUtils.compositeColors(Theme.getColor(ColorId.statusBar), headerBackground)
      ));
    }
  }
}