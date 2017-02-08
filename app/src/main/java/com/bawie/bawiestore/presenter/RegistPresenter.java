package com.bawie.bawiestore.presenter;

import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.RegistErrorBean;
import com.bawie.bawiestore.views.interfaces.RegistView;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/14  10:36.
 */

public class RegistPresenter extends BasePresenter<RegistView> {

    //请求网络
    public void loadregist(String url, OkHttpClientManager.Param[] param){
        okHttpClientManager.requestJson2Bean(url, RegistErrorBean.class, new OkHttpClientManager.RequestJson2BeanCallBack<RegistErrorBean>() {
            @Override
            public void success(RegistErrorBean result) {
                getViews().onSuccess(result);
            }

            @Override
            public void error() {

            }
        },param);
    }

}
