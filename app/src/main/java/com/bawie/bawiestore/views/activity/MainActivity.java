package com.bawie.bawiestore.views.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.fragment.CategeryFragment;
import com.bawie.bawiestore.views.fragment.FindFragment;
import com.bawie.bawiestore.views.fragment.HomeFragment;
import com.bawie.bawiestore.views.fragment.MineFragment;
import com.bawie.bawiestore.views.fragment.ShopFragment;


public class MainActivity extends BaseActivity  {
    private FragmentManager fm;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.mGroup);
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.mFrame, new CategeryFragment() ).commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mHomeBun:

                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.mFrame,new HomeFragment()).commit();

                        break;
                    case R.id.mCategryBun:
                        FragmentTransaction ft1 = fm.beginTransaction();
                        ft1.replace(R.id.mFrame,new CategeryFragment()).commit();
                        break;
                    case R.id.mFindBun:
                        FragmentTransaction ft2 = fm.beginTransaction();
                        ft2.replace(R.id.mFrame,new FindFragment()).commit();

                        break;
                    case R.id.mShopingBun:

                        FragmentTransaction ft3 = fm.beginTransaction();
                        ft3.replace(R.id.mFrame,new ShopFragment()).commit();
                        break;
                    case R.id.mMineBun:
                        FragmentTransaction ft4 = fm.beginTransaction();
                        ft4.replace(R.id.mFrame,new MineFragment()).commit();
                        break;

                    default:
                        break;
                }
            }
        });
    }


}
