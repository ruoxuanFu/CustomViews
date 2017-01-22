package com.quaie.wms.myapplication.ListViewReview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ListView;

import com.quaie.wms.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private ListView mylistview_test;
    private List<list_data> mData;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initView() {
        mylistview_test = (ListView) findViewById(R.id.mylistview_test);
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new list_data("剑伦", "快进草丛"));
        mData.add(new list_data("浪索", "哈萨给"));
        mData.add(new list_data("元素", "啊咦呀"));
        mData.add(new list_data("蚂蚱", "嘿呀啊"));
        mData.add(new list_data("大师", "呵呵呵呵"));
        mData.add(new list_data("小师", "hhhhhhhh"));
        mData.add(new list_data("剑伦", "快进草丛"));
        mData.add(new list_data("浪索", "哈萨给"));
        mData.add(new list_data("元素", "啊咦呀"));
        mData.add(new list_data("蚂蚱", "嘿呀啊"));
        mData.add(new list_data("大师", "呵呵呵呵"));
        mData.add(new list_data("小师", "hhhhhhhh"));
        mData.add(new list_data("剑伦", "快进草丛"));
        mData.add(new list_data("浪索", "哈萨给"));
        mData.add(new list_data("元素", "啊咦呀"));
        mData.add(new list_data("蚂蚱", "嘿呀啊"));
        mData.add(new list_data("大师", "呵呵呵呵"));
        mData.add(new list_data("小师", "hhhhhhhh"));
        mData.add(new list_data("剑伦", "快进草丛"));
        mData.add(new list_data("浪索", "哈萨给"));
        mData.add(new list_data("元素", "啊咦呀"));
        mData.add(new list_data("蚂蚱", "嘿呀啊"));
        mData.add(new list_data("大师", "呵呵呵呵"));
        mData.add(new list_data("小师", "hhhhhhhh"));
        mData.add(new list_data("剑伦", "快进草丛"));
        mData.add(new list_data("浪索", "哈萨给"));
        mData.add(new list_data("元素", "啊咦呀"));
        mData.add(new list_data("蚂蚱", "嘿呀啊"));
        mData.add(new list_data("大师", "呵呵呵呵"));
        mData.add(new list_data("小师", "hhhhhhhh"));

        mAdapter = new MyAdapter(mData, getApplicationContext());
        mylistview_test.setAdapter(mAdapter);
    }

}
