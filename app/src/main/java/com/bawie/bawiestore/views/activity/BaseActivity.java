package com.bawie.bawiestore.views.activity;



import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;


import com.bawie.bawiestore.application.MyApplication;
import com.bawie.bawiestore.views.interfaces.BaseViews;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/27  22:05.
 */

public abstract class BaseActivity extends FragmentActivity implements BaseViews {
    protected SharedPreferences sp;
    protected MyApplication myApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(setViewid());
        initsp();
        initDatass();
    }

//    abstract int setViewid();
    private void initsp() {
        myApplication = (MyApplication) getApplication();
        sp = getSharedPreferences("configs",MODE_PRIVATE);
    }
//    abstract void initView(View view);
    abstract void initDatass();//调P层请求网络
}
