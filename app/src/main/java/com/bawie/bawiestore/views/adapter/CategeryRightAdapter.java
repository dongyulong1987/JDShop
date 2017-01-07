package com.bawie.bawiestore.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.nfc.cardemulation.HostNfcFService;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.bean.CategeryRightTextBean;
import com.bawie.bawiestore.views.activity.ContentActivity;
import com.bawie.bawiestore.views.layoutviews.MyGrideView;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类界面右侧适配器总
 * 创建人 dongyulong
 * 创建时间 2017/1/2  20:26.
 */

public class CategeryRightAdapter extends RecyclerView.Adapter<CategeryRightAdapter.ViewHolder> {
    private Context context;
    private List<CategeryRightTextBean.DatasBean.ClassListBean> list;
    private List<CategeryRightItemAdapter> AList;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            notifyDataSetChanged();

        }
    };


    public CategeryRightAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
        this.AList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.cate_item_right_layout, null));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.textView.setText(list.get(position).getGc_name());
        if(AList.size()>position) {
            holder.gridView.setTag(position);
            holder.gridView.setAdapter(AList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return AList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        MyGrideView gridView;
        View v;

        public ViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            textView = (TextView) v.findViewById(R.id.cate_right_text);
            gridView = (MyGrideView) v.findViewById(R.id.cate_right_gride);

        }
    }

    public void inda(ArrayList<CategeryRightTextBean.DatasBean.ClassListBean> list, List<CategeryRightItemAdapter> AList) {
//        Toast.makeText(context, "" + list.size(), Toast.LENGTH_SHORT).show();
        this.list = list;
        this.AList = AList;
        handler.sendEmptyMessage(0);
    }
}
