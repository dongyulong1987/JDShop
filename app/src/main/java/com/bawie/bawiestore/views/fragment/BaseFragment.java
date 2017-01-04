package com.bawie.bawiestore.views.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * fragment基类
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:05.
 */

public abstract class BaseFragment extends Fragment {
    protected Context context;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initSelfview();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    abstract View initSelfview();//设置自己的view布局
    abstract void initView(View view);//初始化自己布局中的控件
    abstract void initData();//调P层请求网络
}
