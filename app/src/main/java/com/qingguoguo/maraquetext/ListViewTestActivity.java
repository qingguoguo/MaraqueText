package com.qingguoguo.maraquetext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.qingguoguo.maraquetext.customView.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewTestActivity extends AppCompatActivity {
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        listview = (ListView) findViewById(R.id.listview);
        initData();
    }

    private void initData() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add("我是第" + i + "个 item");
        }
        MyAdapter myAdapter = new MyAdapter(strings,this);
        listview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
