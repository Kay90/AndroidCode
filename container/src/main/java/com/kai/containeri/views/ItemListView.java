package com.kai.containeri.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.kai.containeri.Container;
import com.kai.containeri.MainActivity;

/**
 * Created by Kaizen on 2015/8/11.
 */
public class ItemListView extends ListView {

  public ItemListView(Context context) {
    super(context);
  }

  public ItemListView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    final MyListAdapter adapter = new MyListAdapter(getContext());
    setAdapter(adapter);
    setOnItemClickListener(new OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("ItemListView", "onItemClick");
        String item = (String) adapter.getItem(position);
        MainActivity activity = (MainActivity) getContext();
        Container container = activity.getContainer();
        container.showItem(item);
      }
    });
  }
}
