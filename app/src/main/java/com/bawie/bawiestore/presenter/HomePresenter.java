package com.bawie.bawiestore.presenter;

import android.os.Handler;
import android.os.Message;

import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.BaseBean;
import com.bawie.bawiestore.views.interfaces.HomeView;
import com.google.gson.Gson;


import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Home页p层
 * 创建人 dongyulong
 * 创建时间 2016/12/27  20:30.
 */

public class HomePresenter extends BasePresenter<HomeView> {



    public void loadHome(String url){

//        okHttpClientManager.requestJson2Bean(url, BaseBean.class, new OkHttpClientManager.RequestJson2BeanCallBack<BaseBean>() {
//            @Override
//            public void success(BaseBean result) {
//                BaseBean.ResultBean result1 = result.getResult();
//                getViews().onSuccess(result1);
//            }
//
//            @Override
//            public void error() {
//
//            }
//        });


    }
}
