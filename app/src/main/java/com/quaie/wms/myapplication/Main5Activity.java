package com.quaie.wms.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//对话框详解
public class Main5Activity extends AppCompatActivity implements View.OnClickListener {

    private Button AlertDialog01;
    private Button AlertDialog02;
    private Button AlertDialog03;
    private Button AlertDialog04;
    private Button AlertDialog05;

    private AlertDialog mDialog = null;
    private AlertDialog.Builder mBuilder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initView();
    }

    private void initView() {
        AlertDialog01 = (Button) findViewById(R.id.AlertDialog01);
        AlertDialog02 = (Button) findViewById(R.id.AlertDialog02);
        AlertDialog03 = (Button) findViewById(R.id.AlertDialog03);
        AlertDialog04 = (Button) findViewById(R.id.AlertDialog04);
        AlertDialog05 = (Button) findViewById(R.id.AlertDialog05);

        AlertDialog01.setOnClickListener(this);
        AlertDialog02.setOnClickListener(this);
        AlertDialog03.setOnClickListener(this);
        AlertDialog04.setOnClickListener(this);
        AlertDialog05.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AlertDialog01:
                //开始默念
                mDialog = null;
                //第一步
                mBuilder = new AlertDialog.Builder(Main5Activity.this);
                //第二步
                mDialog = mBuilder.setIcon(R.mipmap.iv_lol_icon1)
                        .setTitle("系统提示：")
                        .setMessage("你已经进入对话框范围。")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main5Activity.this, "你点击了确定按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main5Activity.this, "你点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("One More", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main5Activity.this, "你点击了中立按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        //第三步
                        .create();
                mDialog.show();

                break;
            case R.id.AlertDialog02:
                //准备数据源
                final String[] names = new String[]{"Teemo", "Noble", "Able", "Bear", "Pen", "Sibley", "Haber", "Teemo", "Noble", "Able", "Bear", "Pen", "Sibley", "Haber", "Teemo", "Noble", "Able", "Bear", "Pen", "Sibley", "Haber"};
                //默念三部
                mDialog = null;
                mBuilder = new AlertDialog.Builder(Main5Activity.this);
                mDialog = mBuilder.setIcon(R.mipmap.iv_lol_icon2)
                        .setTitle("取一个你喜欢的名字吧")
                        //这里添加一个列表
                        .setItems(names, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main5Activity.this, "你选取的名字是：" + names[which], Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                mDialog.show();

                break;
            case R.id.AlertDialog03:
                final String[] names03 = new String[]{"Teemo", "Noble", "Able", "Bear", "Pen", "Sibley", "Haber", "Teemo", "Noble", "Able", "Bear", "Pen", "Sibley", "Haber", "Teemo", "Noble", "Able", "Bear", "Pen", "Sibley", "Haber"};

                mDialog = null;
                mBuilder = new AlertDialog.Builder(Main5Activity.this);
                mDialog = mBuilder.setIcon(R.mipmap.iv_lol_icon3)
                        .setTitle("再来选择一次吧")
                        .setSingleChoiceItems(names03, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main5Activity.this, "你选取的名字是：" + names03[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main5Activity.this, "确定", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                mDialog.show();

                break;
            case R.id.AlertDialog04:

                final String[] names04 = new String[]{"Teemo", "Noble", "Able", "Bear", "Pen", "Sibley", "Haber",
                        "Teemo1", "Noble1", "Able1", "Bear1", "Pen1", "Sibley1", "Haber1"};

                //给复选按钮赋初始值
                boolean[] checkItems = new boolean[names04.length];
                for (int i = 0; i < names04.length; i++) {
                    if (i < names04.length / 2) {
                        checkItems[i] = false;
                    } else {
                        checkItems[i] = true;
                    }
                }

                mDialog = null;
                mBuilder = new AlertDialog.Builder(Main5Activity.this);
                mDialog = mBuilder.setIcon(R.mipmap.iv_lol_icon3)
                        .setTitle("再来选择一次吧")
                        .setMultiChoiceItems(names04, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(Main5Activity.this, "你选取的名字是：" + names04[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main5Activity.this, "确定", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                mDialog.show();
                break;

            case R.id.AlertDialog05:
                mDialog = null;
                mBuilder = new AlertDialog.Builder(Main5Activity.this);

                //加载布局加载器
                LayoutInflater inflater = getLayoutInflater();
                //后面需要用这个view进行find等一系列操作
                View view_custom = inflater.inflate(R.layout.dialogview, null, false);
                //加载自定义布局
                mBuilder.setView(view_custom);
                //点击非对话框区域对话框不会消失，默认是会消失
                mBuilder.setCancelable(false);

                mDialog = mBuilder.create();

                view_custom.findViewById(R.id.dialog_close).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });

                view_custom.findViewById(R.id.dialog_ok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Main5Activity.this, "ok", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                });

                view_custom.findViewById(R.id.dialog_notok).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Main5Activity.this, "not ok", Toast.LENGTH_SHORT).show();
                        mDialog.dismiss();
                    }
                });
                TextView title = (TextView) view_custom.findViewById(R.id.dialog_title);
                TextView message = (TextView) view_custom.findViewById(R.id.dialog_message);
                title.setText("我是后来加的标题。");
                message.setText("我是后来加的新信息。");

                mDialog.show();
                break;
        }
    }
}
