package com.kai.containeri.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.kai.containeri.R;

/**
 * Created by Kaizen on 2015/8/11.
 */
public class MyListAdapter extends BaseAdapter {

  private String[] items = new String[]{"Hello World", "Hello Container", "Hello Dog", "Hello source"};

  private Context mContext;

  public MyListAdapter(Context context){
    this.mContext = context;
  }

  @Override public int getCount() {
    return items.length;
  }

  @Override public Object getItem(int position) {
    return items[position];
  }

  @Override public long getItemId(int position) {
    return 0;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    convertView = LayoutInflater.from(mContext).inflate(R.layout.detail, null);
    TextView textView = (TextView) convertView.findViewById(R.id.text);
    textView.setText(items[position]);
    return convertView;
  }
}
