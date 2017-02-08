package com.bawie.bawiestore.application;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/30  16:59.
 */

public class MyApplication extends Application {
    protected  Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Fresco.initialize(this);
    }
}
