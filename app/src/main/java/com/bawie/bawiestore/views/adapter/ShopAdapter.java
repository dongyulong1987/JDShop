package com.bawie.bawiestore.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.bean.ShopBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/17  11:20.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private List<ShopBean.DatasBean.CartListBean.GoodsBean> list;
    private Context context;
    private Onclick click;
    private int numss = 0;
    //定义map集合存放position与相对应的值防止混乱
    private Map<Integer, Float> map = new HashMap<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            notifyDataSetChanged();
        }
    };


    public ShopAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.shop_item_layout, null));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ShopBean.DatasBean.CartListBean.GoodsBean goodsBean = list.get(position);
        String goods_num = goodsBean.getGoods_num();
        int num = Integer.parseInt(goods_num);

        String goods_total = goodsBean.getGoods_total();
        float total = Float.parseFloat(goods_total);//总价
        map.put(position, total);


        holder.shopItemShangcheng.setText(goodsBean.getStore_name());
        holder.shopItemFresco.setImageURI(goodsBean.getGoods_image_url());
        holder.shopItemNum.setText("x " + goodsBean.getGoods_num());
        holder.shopItemPrice.setText("￥ " + goodsBean.getGoods_price());
        holder.shopItemName.setText(goodsBean.getGoods_name());

        String info2 = "共 <font color='#FF5001'>" + num + "</font> 件商品，";
        info2 += "合计 <font color='#FF5001'>" + total + "</font> 元";
        holder.shopItemZongnum.setText(Html.fromHtml(info2));
        holder.shopItemNumEdit.setText(num + "");
        //加
        holder.shopItemJiaBun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numedit = holder.shopItemNumEdit.getText().toString().trim();
                int num = Integer.parseInt(numedit);
                float price = Float.parseFloat(list.get(position).getGoods_price());
                num++;
                float total = num * price;
                holder.shopItemNumEdit.setText(num + "");
                holder.shopItemNum.setText("x " + num);
                String info2 = "共 <font color='#FF5001'>" + num + "</font> 件商品，";
                info2 += "合计 <font color='#FF5001'>" + total + "</font> 元";
                holder.shopItemZongnum.setText(Html.fromHtml(info2));
                click.OnJiaPrice(price);
            }
        });
        //减
        holder.shopItemJianBun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numedit = holder.shopItemNumEdit.getText().toString().trim();
                int num = Integer.parseInt(numedit);
                float price = Float.parseFloat(list.get(position).getGoods_price());
                if (num > 1) {
                    num--;
                    float total = num * price;
                    holder.shopItemNumEdit.setText(num + "");
                    holder.shopItemNum.setText("x " + num);
                    String info2 = "共 <font color='#FF5001'>" + num + "</font> 件商品，";
                    info2 += "合计 <font color='#FF5001'>" + total + "</font> 元";
                    holder.shopItemZongnum.setText(Html.fromHtml(info2));
                    click.OnJianPrice(price);
                }
            }
        });
        //删除
        holder.shopItemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.OnRemove(list.get(position).getCart_id(), position);
                //回调
            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setShopOnClickListener(Onclick click) {
        this.click = click;
    }

    //定义接口做点击事件
    public interface Onclick {
        void OnJiaPrice(float price);//加

        void OnJianPrice(float price);//减

        void OnRemove(String cart_id, int position);//删除


    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shop_item_shangcheng)
        TextView shopItemShangcheng;
        @BindView(R.id.shop_item_fresco)
        SimpleDraweeView shopItemFresco;
        @BindView(R.id.shop_item_price)
        TextView shopItemPrice;
        @BindView(R.id.shop_item_num)
        TextView shopItemNum;
        @BindView(R.id.shop_item_zongnum)
        TextView shopItemZongnum;
        @BindView(R.id.shop_item_delete)
        Button shopItemDelete;
        @BindView(R.id.shop_item_jian_bun)
        Button shopItemJianBun;
        @BindView(R.id.shop_item_num_edit)
        EditText shopItemNumEdit;
        @BindView(R.id.shop_item_jia_bun)
        Button shopItemJiaBun;
        @BindView(R.id.shop_item_name)
        TextView shopItemName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void chuan(List<ShopBean.DatasBean.CartListBean.GoodsBean> cart_list) {
        list = cart_list;
        handler.sendEmptyMessage(0);
    }


}
