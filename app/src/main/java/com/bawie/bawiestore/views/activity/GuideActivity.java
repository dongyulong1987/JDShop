
package com.bawie.bawiestore.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.adapter.GuideAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/27  22:56.
 */
public class GuideActivity extends BaseActivity{
    private ViewPager viewPager;
    private List<View> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);
        viewPager = (ViewPager) findViewById(R.id.g_view);
        list = new ArrayList<>();
        list.add(View.inflate(this,R.layout.guideone,null));
        list.add(View.inflate(this,R.layout.guidetwo,null));
        list.add(View.inflate(this,R.layout.guidethree,null));
        View v = View.inflate(this,R.layout.guidefour,null);
        Button g_bun = (Button) v.findViewById(R.id.g_click);
        g_bun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        list.add(v);
        GuideAdapter adapter = new GuideAdapter(this,list);
        viewPager.setAdapter(adapter);

    }

    @Override
    void initDatass() {

    }
}
