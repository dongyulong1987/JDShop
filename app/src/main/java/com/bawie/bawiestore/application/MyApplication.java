package com.bawie.bawiestore.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/30  16:59.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
