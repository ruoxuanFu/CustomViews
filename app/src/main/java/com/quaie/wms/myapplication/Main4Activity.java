package com.quaie.wms.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.quaie.wms.myapplication.Adapters.MyBaseExpandableListAdapter;
import com.quaie.wms.myapplication.Bean.Child;
import com.quaie.wms.myapplication.Bean.Group;

import java.util.ArrayList;

//一些可以折叠的效果
public class Main4Activity extends AppCompatActivity {
    //不会自带分隔符的自动完成文本框
    private AutoCompleteTextView mAuto;
    //自带分隔符的自动完成文本框
    private MultiAutoCompleteTextView mMulti;
    //可折叠的listview
    private ExpandableListView mExpandableListView;
    //为可折叠listview准备数据
    private ArrayList<Group> mData_Group = null;
    private ArrayList<ArrayList<Child>> mData_Child = null;
    private ArrayList<Child> mData;
    //为可折叠listview准备适配器
    private MyBaseExpandableListAdapter mMyEListAdapter;

    private static final String[] data = new String[]{"abc", "djs", "zxcee", "MMAS", "Aaa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                Main4Activity.this,
                android.R.layout.simple_dropdown_item_1line,
                data);

        mAuto.setAdapter(adapter);

        mMulti.setAdapter(adapter);
        mMulti.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        initData();
    }

    private void initData() {
        mData_Group = new ArrayList<>();
        mData_Group.add(new Group("AD"));
        mData_Group.add(new Group("AP"));
        mData_Group.add(new Group("TANK"));

        mData_Child = new ArrayList<>();

        //AD组
        mData = new ArrayList<>();
        mData.add(new Child(R.mipmap.iv_lol_icon3, "剑圣"));
        mData.add(new Child(R.mipmap.iv_lol_icon4, "德莱文"));
        mData.add(new Child(R.mipmap.iv_lol_icon13, "男枪"));
        mData.add(new Child(R.mipmap.iv_lol_icon14, "韦鲁斯"));
        mData_Child.add(mData);
        //AP组
        mData = new ArrayList<>();
        mData.add(new Child(R.mipmap.iv_lol_icon1, "提莫"));
        mData.add(new Child(R.mipmap.iv_lol_icon7, "安妮"));
        mData.add(new Child(R.mipmap.iv_lol_icon8, "天使"));
        mData.add(new Child(R.mipmap.iv_lol_icon9, "泽拉斯"));
        mData.add(new Child(R.mipmap.iv_lol_icon11, "狐狸"));
        mData_Child.add(mData);
        //TANK组
        mData = new ArrayList<>();
        mData.add(new Child(R.mipmap.iv_lol_icon2, "诺手"));
        mData.add(new Child(R.mipmap.iv_lol_icon5, "德邦"));
        mData.add(new Child(R.mipmap.iv_lol_icon6, "奥拉夫"));
        mData.add(new Child(R.mipmap.iv_lol_icon10, "龙女"));
        mData.add(new Child(R.mipmap.iv_lol_icon12, "狗熊"));
        mData_Child.add(mData);

        mMyEListAdapter = new MyBaseExpandableListAdapter(mData_Group, mData_Child, getApplicationContext());
        mExpandableListView.setAdapter(mMyEListAdapter);
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(getApplicationContext(),
                        mData_Child.get(groupPosition).get(childPosition).getcName(),
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    private void initView() {
        mAuto = (AutoCompleteTextView) findViewById(R.id.Auto);
        mMulti = (MultiAutoCompleteTextView) findViewById(R.id.Multi);
        mExpandableListView = (ExpandableListView) findViewById(R.id.exlist_lol);
    }
}
