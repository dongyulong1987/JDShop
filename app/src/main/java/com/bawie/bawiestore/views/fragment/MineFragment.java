package com.bawie.bawiestore.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.interfaces.HomeView;
import com.bawie.bawiestore.views.interfaces.MineView;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:05.
 */

public class MineFragment extends BaseFragment implements MineView{


    @Override
    View initSelfview() {
        return View.inflate(getActivity(),R.layout.minefragment,null);
    }

    @Override
    void initView(View view) {

    }

    @Override
    void initData() {

    }


}
