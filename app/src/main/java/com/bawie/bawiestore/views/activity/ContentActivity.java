package com.bawie.bawiestore.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bawie.bawiestore.R;

/**
 * 商品详情界面
 * 创建人 dongyulong
 * 创建时间 2017/1/4  19:04.
 */

public class ContentActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        Intent intent = getIntent();
        String gc_id = intent.getStringExtra("gc_id");
        System.out.println("gc++++++++++++++++"+gc_id );
    }
}
