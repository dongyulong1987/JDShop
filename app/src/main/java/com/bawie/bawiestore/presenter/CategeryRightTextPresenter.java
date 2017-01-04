package com.bawie.bawiestore.presenter;

import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.CategeryRightTextBean;
import com.bawie.bawiestore.views.interfaces.CategeryRightTextView;


import java.util.List;

import static android.R.id.list;

/**
 *
 * 分类界面右侧text布局
 * 创建人 dongyulong
 * 创建时间 2017/1/2  20:42.
 */

public class CategeryRightTextPresenter extends BasePresenter<CategeryRightTextView> {
    public void loadCategeryRightText(String url, final List<CategeryRightTextBean.DatasBean.ClassListBean> list) {
        okHttpClientManager.requestJson2Bean(url, CategeryRightTextBean.class, new OkHttpClientManager.RequestJson2BeanCallBack<CategeryRightTextBean>() {


            @Override
            public void success(CategeryRightTextBean result) {
                CategeryRightTextBean.DatasBean datas = result.getDatas();
                getViews().onSuccess(datas,list);
            }


            @Override
            public void error() {

            }
        });

    }
    public void loadCategeryRightGride(String url, final List<CategeryRightTextBean.DatasBean.ClassListBean> list) {
        okHttpClientManager.requestJson2Bean(url, CategeryRightTextBean.class, new OkHttpClientManager.RequestJson2BeanCallBack<CategeryRightTextBean>() {


            @Override
            public void success(CategeryRightTextBean result) {
                CategeryRightTextBean.DatasBean datas = result.getDatas();
                getViews().onSuccesses(datas,list);
            }


            @Override
            public void error() {

            }
        });
    }
}
