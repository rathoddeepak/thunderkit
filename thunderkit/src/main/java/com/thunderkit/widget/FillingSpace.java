package com.thunderkit.widget;

import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;

import com.thunderkit.navigation.ViewController;
import com.thunderkit.support.ViewSupport;
import com.thunderkit.theme.ColorId;
import com.thunderkit.tool.Views;

import me.vkryl.core.lambda.Destroyable;

public class FillingSpace extends View implements Destroyable {
  public FillingSpace (Context context) {
    super(context);
    setVisibility(View.GONE);
  }

  public boolean setLayoutHeight (int height, boolean updateVisibility) {
    boolean updated = Views.setLayoutHeight(this, height);
    if (updateVisibility) {
      setVisibility(height > 0 ? View.VISIBLE : View.GONE);
    }
    return updated;
  }

  private ViewController<?> themeProvider;

  public void setThemedBackground (@ColorId int colorId, @Nullable ViewController<?> themeProvider) {
    this.themeProvider = themeProvider;
    ViewSupport.setThemedBackground(this, colorId, themeProvider);
  }

  @Override
  public void performDestroy () {
    if (themeProvider != null) {
      themeProvider.removeThemeListenerByTarget(this);
      themeProvider = null;
    }
  }
}
