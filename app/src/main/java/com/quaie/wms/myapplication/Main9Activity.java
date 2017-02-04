package com.quaie.wms.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

//bundle传递信息的目标activity
public class Main9Activity extends AppCompatActivity {

    private TextView main9_textinfo;

    private String mUser_id;
    private String mUser_psd;
    private String mUser_sex;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    main9_textinfo.setText("Error");
                    break;
                case 2:
                    main9_textinfo.setText("用户名：" + mUser_id + "\n" + "密码：" + mUser_psd + "\n" + "性别：" + mUser_sex + "\n");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        initView();
        initData();
    }

    private void initData() {
        Intent getUserData = getIntent();
        Bundle getbd = getUserData.getExtras();
        mUser_id = getbd.getString("userid");
        mUser_psd = getbd.getString("userpsd");
        mUser_sex = getbd.getString("usersex");

        if (TextUtils.isEmpty(mUser_id) || TextUtils.isEmpty(mUser_psd) || TextUtils.isEmpty(mUser_sex)) {
            handler.sendEmptyMessage(1);
        } else {
            handler.sendEmptyMessage(2);
        }
    }

    private void initView() {
        main9_textinfo = (TextView) findViewById(R.id.main9_textinfo);
    }
}
