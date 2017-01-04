package com.bawie.bawiestore.views.fragment;

import android.view.View;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.api_net.BaseNet;
import com.bawie.bawiestore.model.bean.BaseBean;
import com.bawie.bawiestore.presenter.HomePresenter;
import com.bawie.bawiestore.views.interfaces.HomeView;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:05.
 */

public class HomeFragment extends BaseFragment implements HomeView{

    //设置视图布局文件
    @Override
    View initSelfview() {
        return View.inflate(getActivity(),R.layout.homefragment,null);
    }
    //初始化控件
    @Override
    void initView(View view) {
//        view.findViewById();
    }
    //调用P层数据
    @Override
    void initData() {
        HomePresenter homePresenter = new HomePresenter();
        homePresenter.setViews(this);
        homePresenter.loadHome(BaseNet.LINK_MOBILE_INDEX);
    }

    @Override
    public void onSuccess(BaseBean.ResultBean result1) {
        System.out.println("++++++++++"+result1.getData().get(0).getAuthor_name());
    }
}
