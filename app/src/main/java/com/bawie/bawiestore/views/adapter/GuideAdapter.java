package com.bawie.bawiestore.views.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.activity.GuideActivity;

import java.util.List;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/27  23:18.
 */

public class GuideAdapter extends PagerAdapter {
    private Context context;
    private List<View> list;
    public GuideAdapter(GuideActivity guideActivity, List<View> list) {
        context = guideActivity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));


        return list.get(position);
    }
}
