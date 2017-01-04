package com.bawie.bawiestore.presenter;


import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.CategeryBean;
import com.bawie.bawiestore.views.interfaces.CategeryView;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/29  10:13.
 */

public class CategeryPresenter extends BasePresenter<CategeryView> {


    public void loadCategery(String url) {
        okHttpClientManager.requestJson2Bean(url, CategeryBean.class, new OkHttpClientManager.RequestJson2BeanCallBack<CategeryBean>() {
            @Override
            public void success(CategeryBean result) {
                CategeryBean.DatasBean datas = result.getDatas();
                getViews().onSuccess(datas);
            }

            @Override
            public void error() {

            }
        });
    }

}
