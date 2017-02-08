package com.bawie.bawiestore.presenter;

import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.LoginBean;
import com.bawie.bawiestore.views.interfaces.LoginViews;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/13  11:07.
 */

public class LoginPresenter extends BasePresenter<LoginViews> {
        public void loadLogin(String url, OkHttpClientManager.Param[] param){
            okHttpClientManager.requestJson2Bean(url, LoginBean.class, new OkHttpClientManager.RequestJson2BeanCallBack<LoginBean>() {
                @Override
                public void success(LoginBean result) {
                    getViews().onSuccess(result);
                }

                @Override
                public void error() {

                }
            },param);
        }

}
