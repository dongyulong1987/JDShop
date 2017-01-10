package com.bawie.bawiestore.views.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.activity.ContentdetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/10  20:09.
 */

public class MyDetailViewPagerAdapter extends PagerAdapter {
    private Context context;
    private String[] str;

    public MyDetailViewPagerAdapter(ContentdetailsActivity contentdetailsActivity, String[] str) {
        context = contentdetailsActivity;
        this.str = str;
    }

    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = View.inflate(context, R.layout.contdetailviewpager_item, null);
        SimpleDraweeView image = (SimpleDraweeView) v.findViewById(R.id.cont_detail_viewitem);
        image.setImageURI(str[position]);
        container.addView(v);
        return v;
    }
}
