package com.bawie.bawiestore.views.adapter;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.bean.CategeryBean;
import com.bawie.bawiestore.views.fragment.CategeryFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;
import java.util.List;

/**
 * 分类页左侧listview适配器
 * 创建人 dongyulong
 * 创建时间 2016/12/30  16:38.
 */

public class CategeryAdapter extends BaseAdapter {
    private Context context;
    private List<CategeryBean.DatasBean.ClassListBean> list;
    public CategeryAdapter(Context categeryFragment, List<CategeryBean.DatasBean.ClassListBean> list) {
        context = categeryFragment;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.cate_item_left_layout,null);
            holder.image = (SimpleDraweeView) convertView.findViewById(R.id.cate_left_image);
            holder.text = (TextView) convertView.findViewById(R.id.cate_left_text);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        CategeryBean.DatasBean.ClassListBean listBean = list.get(position);

        holder.text.setText(listBean.getGc_name());
        holder.image.setImageURI(Uri.parse(listBean.getImage()));
        if(listBean.isFlag()){
            holder.text.setTextColor(Color.RED);
        }else{
            holder.text.setTextColor(Color.GRAY);
        }


        return convertView;
    }
    class ViewHolder{
        SimpleDraweeView image;
        TextView text;
    }

}
