package com.quaie.wms.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.quaie.wms.myapplication.MyTask.MyAsyncTask;

//AsyncTask异步任务
public class Main7Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView asy_text;
    private ProgressBar asy_probar;
    private Button asy_btn;
    private Button asy_cancel;
    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        initView();
    }

    private void initView() {
        asy_text = (TextView) findViewById(R.id.asy_text);
        asy_probar = (ProgressBar) findViewById(R.id.asy_probar);
        asy_btn = (Button) findViewById(R.id.asy_btn);
        asy_cancel = (Button) findViewById(R.id.asy_cancel);

        asy_btn.setOnClickListener(this);
        asy_cancel.setOnClickListener(this);
        myAsyncTask = new MyAsyncTask(asy_text, asy_probar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.asy_btn:
                myAsyncTask.execute(1000);
                break;

            case R.id.asy_cancel:
                myAsyncTask.cancel(true);
                break;
        }
    }
}
