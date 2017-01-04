package com.bawie.bawiestore.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.interfaces.FindView;
import com.bawie.bawiestore.views.interfaces.HomeView;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:05.
 */

public class FindFragment extends BaseFragment implements FindView{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.findfragment,container,false);
    }

    @Override
    View initSelfview() {
        return View.inflate(getActivity(),R.layout.findfragment,null);
    }

    @Override
    void initView(View view) {

    }

    @Override
    void initData() {

    }

    @Override
    public void onSuccess() {

    }
}
