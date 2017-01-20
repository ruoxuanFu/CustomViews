package com.quaie.wms.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;

import com.quaie.wms.myapplication.View.EditTextCanClear;

/**
 * 带删除按钮的Edittext
 */
public class EditTextCanClearActivity extends AppCompatActivity {

    private EditTextCanClear mCanClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCanClear = (EditTextCanClear) findViewById(R.id.clear_edittext);
        mCanClear.setCEOnFocusChangeListener(new EditTextCanClear.setCEOnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("THIS", "I have a focus.");
            }
        });

        mCanClear.setCEaddTextChangedListener(new EditTextCanClear.setCEaddTextChangedListener() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("THIS", "beforeTextChanged = " + s + ";" + start + ";" + count + ";" + after);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("THIS", "onTextChanged = " + s + ";" + start + ";" + count + ";" + before);

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("THIS", "afterTextChanged = " + s);
            }
        });
    }
}
