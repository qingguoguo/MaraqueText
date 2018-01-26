package com.qingguoguo.maraquetext.customview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qingguoguo.maraquetext.R;

import java.util.List;

/**
 * @author :qingguoguo
 * @datetime ：2018/1/18
 * @describe :
 */

public class MyAdapter extends BaseAdapter {
    public static final String TAG = MyAdapter.class.getSimpleName();
    private List<String> data;
    private Context mContext;

    public MyAdapter(List<String> data, Context context) {
        this.data = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "getView:" + position + ",convertView:" + convertView + ",parent:" + parent);
        if (convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.item_text);
        textView.setText(getItem(position));
        return convertView;
    }
}