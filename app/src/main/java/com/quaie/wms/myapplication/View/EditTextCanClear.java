package com.quaie.wms.myapplication.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.quaie.wms.myapplication.R;


/**
 * Created by yue on 2017/1/20.
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
 * 　　　　　　　　　┗┓┓┏ ┳┓┏┛ + + + +
 * 　　　　　　　　　 ┃┫┫ ┃┫┫
 * 　　　　　　　　　 ┗┻┛ ┗┻┛+ + + +
 * 带删除按钮的edittext
 */

public class EditTextCanClear extends EditText {

    private Drawable mClearBtn;
    private boolean mHasFoucs;

    //设置焦点监听
    public interface setCEOnFocusChangeListener {
        public void onFocusChange(View v, boolean hasFocus);
    }

    //自定义焦点监听接口的成员
    public setCEOnFocusChangeListener mCEOnFocusChangeListener;

    //自定义焦点监听接口对外开放的set方法
    public void setCEOnFocusChangeListener(setCEOnFocusChangeListener listener) {
        this.mCEOnFocusChangeListener = listener;
    }

    //设置输入框输入情况焦点监听
    public interface setCEaddTextChangedListener {
        public void beforeTextChanged(CharSequence s, int start, int count, int after);

        public void onTextChanged(CharSequence s, int start, int before, int count);

        public void afterTextChanged(Editable s);
    }

    //自定义焦点监听接口的成员
    public setCEaddTextChangedListener mCEaddTextChangedListener;

    //自定义焦点监听接口对外开放的set方法
    public void setCEaddTextChangedListener(setCEaddTextChangedListener listener) {
        this.mCEaddTextChangedListener = listener;
    }

    public EditTextCanClear(Context context) {
        this(context, null);
    }

    public EditTextCanClear(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public EditTextCanClear(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mClearBtn = getCompoundDrawables()[2];

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.EditTextCanClear, defStyleAttr, 0);

        mClearBtn = ta.getDrawable(R.styleable.EditTextCanClear_setClearBtnImg);

        ta.recycle();

        initClearBtn();
    }

    private void initClearBtn() {

        mClearBtn.setBounds(0, 0, mClearBtn.getIntrinsicWidth(), mClearBtn.getIntrinsicHeight());

        setClearDrawable(false);
        // 设置焦点改变的监听
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mHasFoucs = hasFocus;
                if (mHasFoucs) {
                    setClearDrawable(getText().length() > 0);
                } else {
                    setClearDrawable(false);
                }

                if (mCEOnFocusChangeListener != null) {
                    mCEOnFocusChangeListener.onFocusChange(v, hasFocus);
                }
            }
        });
        // 设置输入框里面内容发生改变的监听
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (mCEaddTextChangedListener != null) {
                    mCEaddTextChangedListener.beforeTextChanged(s, start, count, after);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mHasFoucs) {
                    setClearDrawable(s.length() > 0);
                }

                if (mCEaddTextChangedListener != null) {
                    mCEaddTextChangedListener.onTextChanged(s, start, before, count);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mCEaddTextChangedListener != null) {
                    mCEaddTextChangedListener.afterTextChanged(s);
                }
            }
        });
    }

    private void setClearDrawable(boolean visible) {
        Drawable drawable = visible ? mClearBtn : null;
        setCompoundDrawables(
                getCompoundDrawables()[0],
                getCompoundDrawables()[1],
                drawable,
                getCompoundDrawables()[3]
        );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (mClearBtn != null) {
                    //获得点击位置
                    int eventX = (int) event.getRawX();
                    int eventY = (int) event.getRawY();
                    Log.e("THIS", "eventX = " + eventX + "; eventY = " + eventY);
                    //获得点击矩形区域
                    Rect rect = new Rect();
                    getGlobalVisibleRect(rect);
                    //点击区域的左边界
                    int right = mClearBtn.getBounds().right;
                    rect.left = rect.right - px2dp(right);

                    //判断当前点击的位置(eventX, eventY)是否在rect内部
                    if (rect.contains(eventX, eventY)) {
                        setText("");
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private int px2dp(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal,
                getResources().getDisplayMetrics());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
