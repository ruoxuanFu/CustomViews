package com.quaie.wms.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.quaie.wms.myapplication.Adapters.MyDrawerAdapter;
import com.quaie.wms.myapplication.Bean.Item;
import com.quaie.wms.myapplication.Fragments.ContentFragment;

import java.util.ArrayList;

//DrawerLayout官方侧滑菜单
public class Main6Activity extends AppCompatActivity {


    private FrameLayout ly_content;
    private ListView list_left_drawer;
    private DrawerLayout activity_main6;
    private ArrayList<Item> mDrawerList;
    private MyDrawerAdapter myDrawerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        initView();
        initData();
    }

    private void initData() {
        mDrawerList = new ArrayList<>();
        mDrawerList.add(new Item(R.mipmap.iv_lol_icon1, "实时信息"));
        mDrawerList.add(new Item(R.mipmap.iv_lol_icon2, "提醒通知"));
        mDrawerList.add(new Item(R.mipmap.iv_lol_icon3, "活动路线"));
        mDrawerList.add(new Item(R.mipmap.iv_lol_icon4, "相关设置"));

        myDrawerAdapter = new MyDrawerAdapter(mDrawerList, Main6Activity.this);

        list_left_drawer.setAdapter(myDrawerAdapter);

        list_left_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContentFragment contentFragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putString("text", mDrawerList.get(position).getNames());
                contentFragment.setArguments(args);
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.ly_content, contentFragment).commit();
                activity_main6.closeDrawer(list_left_drawer);
            }
        });
    }

    private void initView() {
        ly_content = (FrameLayout) findViewById(R.id.ly_content);
        list_left_drawer = (ListView) findViewById(R.id.list_left_drawer);
        activity_main6 = (DrawerLayout) findViewById(R.id.activity_main6);
    }
}
