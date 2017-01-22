package com.quaie.wms.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ClockClock extends AppCompatActivity implements View.OnClickListener {

    private TextView content_text;
    private TimePicker timePicker;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DatePicker datepicker;

    private long time;
    private Calendar calendar;

    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private Chronometer chronometer_test;
    private Button start;
    private Button pause;
    private Button resetting;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        time = System.currentTimeMillis();
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);

        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR);
        mMinute = calendar.get(Calendar.MINUTE);

        initView();
        initData();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initData() {
        content_text.setText(mYear + "/" + (mMonth + 1) + "/" + mDay + "   " + mHour + ":" + mMinute);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                content_text.setText(datepicker.getYear() + "/" + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() + "   " + hourOfDay + ":" + minute);
            }
        });

        datepicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                content_text.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth + "   " + mHour + ":" + mMinute);
            }
        });

        chronometer_test.setFormat("Time：%s");
        chronometer_test.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                String time = chronometer.getText().toString();
                if (time.equals("Time：00:10")) {
                    Toast.makeText(ClockClock.this, "时间到了~", Toast.LENGTH_SHORT).show();
                    chronometer_test.stop();
                }
            }
        });
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        content_text = (TextView) findViewById(R.id.content_text);
        timePicker = (TimePicker) findViewById(R.id.timepicker_test);
        datepicker = (DatePicker) findViewById(R.id.datepicker_test);
        chronometer_test = (Chronometer) findViewById(R.id.chronometer_test);
        start = (Button) findViewById(R.id.start);
        pause = (Button) findViewById(R.id.pause);
        resetting = (Button) findViewById(R.id.resetting);

        resetting.setOnClickListener(this);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                chronometer_test.start();
                chronometer_test.setBase(SystemClock.elapsedRealtime());
                break;
            case R.id.pause:
                chronometer_test.stop();
                break;
            case R.id.resetting:
                chronometer_test.setBase(SystemClock.elapsedRealtime());
                break;
        }
    }
}
