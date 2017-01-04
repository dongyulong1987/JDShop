package com.bawie.bawiestore.views.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.bean.CategeryRightTextBean;
import com.bawie.bawiestore.views.interfaces.CategeryRightTextView;

import java.util.List;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/3  16:28.
 */

public class CategeryRightItemAdapter extends BaseAdapter {
    private Context context;
    private List<CategeryRightTextBean.DatasBean.ClassListBean> list;

    public   CategeryRightItemAdapter(Context context, List<CategeryRightTextBean.DatasBean.ClassListBean> data) {
        this.context = context;
        list = data;
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
        ViewHolder holder=null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.cate_right_gride_item_layout,null);
            holder.tv = (TextView) convertView.findViewById(R.id.cate_right_gride_item);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setTag(position);
        holder.tv.setText(list.get(position).getGc_name());

        return convertView;
    }

    class ViewHolder {
        TextView tv;

    }
}