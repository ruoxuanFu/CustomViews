package com.quaie.wms.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class Main4Activity extends AppCompatActivity {
    //不会自带分隔符
    private AutoCompleteTextView Auto;
    //自带分隔符
    private MultiAutoCompleteTextView Multi;

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

        Auto.setAdapter(adapter);

        Multi.setAdapter(adapter);
        Multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    private void initView() {
        Auto = (AutoCompleteTextView) findViewById(R.id.Auto);
        Multi = (MultiAutoCompleteTextView) findViewById(R.id.Multi);
    }
}
