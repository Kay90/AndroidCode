package com.kai.containeri.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kai.containeri.Container;
import com.kai.containeri.MainActivity;
import com.kai.containeri.R;

/**
 * Created by Kaizen on 2015/8/11.
 */
public class MyDetailView extends LinearLayout {

  TextView textView;

  public MyDetailView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    textView = (TextView) findViewById(R.id.text);
    findViewById(R.id.button).setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        MainActivity activity = (MainActivity) getContext();
        Container container = activity.getContainer();
        container.showItem("Hello world");
      }
    });
  }

  public void setItem(String item) {
    textView.setText(item);
  }
}
