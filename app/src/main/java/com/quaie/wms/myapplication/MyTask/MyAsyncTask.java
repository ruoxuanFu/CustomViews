package com.quaie.wms.myapplication.MyTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by yue on 2017/2/4.
 * 　　　　　　　  ┏┓　 ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　     ┃
 * 　　　　　　　┃　　　━　    ┃ ++ + + +
 * 　　　　　　 ████━████     ┃++  ++
 * 　　　　　　　┃　　　　　　 ┃ +
 * 　　　　　　　┃　　　┻　　　┃  +  +
 * 　　　　　　　┃　　　　　　 ┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * 异步类，需要自己继承重写
 */

public class MyAsyncTask extends AsyncTask {

    private TextView tv;
    private ProgressBar pro;

    public MyAsyncTask(TextView tv, ProgressBar pro) {
        super();
        this.tv = tv;
        this.pro = pro;
    }

    //将在onPreExecute 方法执行后马上执行，该方法运行在后台线程中。
    //这里将主要负责执行那些很耗时的后台计算工作。可以调用 publishProgress方法来更新实时的任务进度。
    @Override
    protected Object doInBackground(Object[] params) {
        Log.d("MyAsyncTask", "doInBackground");
        doDelayOperator delayOperator = new doDelayOperator();
        int i;
        for (i = 0; i < 16; i++) {
            delayOperator.delay();

            //调用onProgressUpdate
            publishProgress(i);
        }
        return null;
    }

    //该方法将在执行实际的后台操作前被UI thread调用
    //可以在该方法中做一些准备工作
    @Override
    protected void onPreExecute() {
        Log.d("MyAsyncTask", "onPreExecute");
        tv.setText("loading...");
    }

    //在publishProgress方法被调用后，UI线程将调用这个方法从而在界面上展示任务的进展情况
    @Override
    protected void onProgressUpdate(Object[] values) {
        Log.d("MyAsyncTask", "onProgressUpdate");
        pro.incrementProgressBy((Integer) values[0]);
        tv.setText(pro.getProgress() + "%");
    }

    //当doInBackground运行完成后，调用该方法
    @Override
    protected void onPostExecute(Object o) {
        Log.d("MyAsyncTask", "onPostExecute");
        tv.setText("over");
    }

    //延时操作,用来模拟下载
    public class doDelayOperator {
        public void delay() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCancelled() {
        Log.d("MyAsyncTask", "onCancelled");
        pro.incrementProgressBy(0);
    }
}
