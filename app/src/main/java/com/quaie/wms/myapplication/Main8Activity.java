package com.quaie.wms.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.quaie.wms.myapplication.Bean.PersonInfo;
import com.quaie.wms.myapplication.Bean.PersonInfoMore;
import com.quaie.wms.myapplication.View.EditTextCanClear;

//bundle传递信息
public class Main8Activity extends AppCompatActivity implements View.OnClickListener {

    private EditTextCanClear main8_id;
    private EditTextCanClear main8_psd;
    private RadioButton sex_man;
    private RadioButton sex_woman;
    private Button main8_btn;
    private RadioGroup main8_rg;

    private String mUser_id;
    private String mUser_psd;
    private String mUser_sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        initView();

    }

    private void initView() {
        main8_id = (EditTextCanClear) findViewById(R.id.main8_id);
        main8_psd = (EditTextCanClear) findViewById(R.id.main8_psd);
        sex_man = (RadioButton) findViewById(R.id.sex_man);
        sex_woman = (RadioButton) findViewById(R.id.sex_woman);
        main8_btn = (Button) findViewById(R.id.main8_btn);
        main8_rg = (RadioGroup) findViewById(R.id.main8_rg);

        main8_btn.setOnClickListener(this);

        main8_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sex_man:
                        mUser_sex = (String) sex_man.getText();
                        break;
                    case R.id.sex_woman:
                        mUser_sex = (String) sex_woman.getText();
                        break;
                }
            }
        });

        main8_id.setCEaddTextChangedListener(new EditTextCanClear.setCEaddTextChangedListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser_id = s.toString().trim();
            }
        });

        main8_psd.setCEaddTextChangedListener(new EditTextCanClear.setCEaddTextChangedListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser_psd = s.toString().trim();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main8_btn:
                if (TextUtils.isEmpty(mUser_id) || TextUtils.isEmpty(mUser_psd) || TextUtils.isEmpty(mUser_sex)) {
                    Toast.makeText(this, "请完善信息。", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, Main9Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("userid", mUser_id);
                    bundle.putString("userpsd", mUser_psd);
                    bundle.putString("usersex", mUser_sex);

                    //bundle传递Serializable对象
                    PersonInfo personInfo = new PersonInfo();
                    personInfo.setAge(20);
                    personInfo.setBirthday("7/15");
                    personInfo.setAddress("南海市南山区南山南");
                    personInfo.setTelphone("110");
                    bundle.putSerializable("personinfo", personInfo);

                    //bundle传递Parcelable对象
                    PersonInfoMore personInfoMore = new PersonInfoMore();
                    personInfoMore.setLikeSome("吃饭睡觉打豆豆");
                    personInfoMore.setConstellation("人见人爱花见花开处女座");
                    personInfoMore.setLolAddress("弗雷尔卓德");
                    bundle.putParcelable("personinfomore", personInfoMore);

                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                }
                break;
        }
    }
}
