package com.bawie.bawiestore.presenter;

import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.views.interfaces.BaseViews;

/**
 * presenter基类
 * 创建人 dongyulong
 * 创建时间 2016/12/27  20:32.
 */

public class BasePresenter <T extends BaseViews>{
    private T views;
    public OkHttpClientManager okHttpClientManager;
    {
        okHttpClientManager = OkHttpClientManager.getInstance();
    }

    public T getViews() {
        return views;
    }

    public void setViews(T views) {
        this.views = views;
    }
}
