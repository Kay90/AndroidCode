package com.kai.containeri.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.kai.containeri.Container;
import com.kai.containeri.R;

/**
 * Created by Kaizen on 2015/8/11.
 */
public class DualPaneContainer extends LinearLayout implements Container {

  private MyDetailView detailView;

  public DualPaneContainer(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    detailView = (MyDetailView) getChildAt(1);
  }

  @Override public void showItem(String item) {
    detailView.setItem(item);
  }

  @Override public boolean onBackPressed() {
    return false;
  }

  public class SinglePaneContainer extends FrameLayout implements Container {

    private ItemListView listView;

    public SinglePaneContainer(Context context, AttributeSet attrs) {
      super(context, attrs);
    }

    @Override protected void onFinishInflate() {
      super.onFinishInflate();
      listView = (ItemListView) getChildAt(0);
    }

    @Override public void showItem(String item) {
      if (listViewAttached()) {
        removeViewAt(0);
        View.inflate(getContext(), R.layout.detail, this);
      }
      MyDetailView detailView = (MyDetailView) getChildAt(0);
      detailView.setItem(item);
    }

    @Override public boolean onBackPressed() {
      if (!listViewAttached()) {
        removeViewAt(0);
        addView(listView);
        return true;
      }
      return false;
    }

    private boolean listViewAttached() {
      return listView.getParent() != null;
    }
  }
}
