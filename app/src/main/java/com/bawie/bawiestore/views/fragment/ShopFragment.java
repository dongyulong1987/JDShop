package com.bawie.bawiestore.views.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.api_net.BaseNet;
import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.ShopBean;
import com.bawie.bawiestore.model.bean.ShopDeleteBean;
import com.bawie.bawiestore.presenter.ShopPresenter;
import com.bawie.bawiestore.views.activity.LoginActivity;
import com.bawie.bawiestore.views.activity.MainActivity;
import com.bawie.bawiestore.views.activity.OrderActivity;
import com.bawie.bawiestore.views.adapter.ShopAdapter;
import com.bawie.bawiestore.views.interfaces.ShopView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 购物车页面
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:05.
 */

public class ShopFragment extends BaseFragment implements ShopView, ShopAdapter.Onclick {


    private String key;
    private List<ShopBean.DatasBean.CartListBean.GoodsBean> goods_list = new ArrayList<>();
    private ShopAdapter adapter;
    private TextView shopitemnull;
    private SwipeRefreshLayout swipes;
    private Button showbuy;
    private RecyclerView recyclerView;
    private LinearLayout ll;
    private TextView shoptext;
    private int nums = 0;
    private float totals = 0.00f;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            goods_list.clear();
            nums = 0;
            totals = 0.00f;
            OkHttpClientManager.Param param = new OkHttpClientManager.Param("key", sp.getString("key", ""));
            shopPresenter.loadshop(BaseNet.LINK_MOBILE_CART, param);
            swipes.setRefreshing(false);
        }
    };
    private ShopPresenter shopPresenter;
    private AlertDialog dialog;

    @Override
    View initSelfview() {

        View v;
        if (sp.getBoolean("typetoken", false)) {
            v = View.inflate(getActivity(), R.layout.shopfragment, null);
        } else {
            v = View.inflate(getActivity(), R.layout.shopnologin, null);
            TextView t = (TextView) v.findViewById(R.id.shopno_text);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });
        }

        return v;
    }

    @Override
    void initView(View view) {
        if (sp.getBoolean("typetoken", false)) {
            swipes = (SwipeRefreshLayout) view.findViewById(R.id.shop_swipes);
            shopitemnull = (TextView) view.findViewById(R.id.shop_null);
            showbuy = (Button) view.findViewById(R.id.shop_buy);
            recyclerView = (RecyclerView) view.findViewById(R.id.shop_recycle);
            ll = (LinearLayout) view.findViewById(R.id.shop_ll);
            shoptext = (TextView) view.findViewById(R.id.shop_text);
            //下拉刷新
            swipes.setProgressViewOffset(true, 0, 180);//设置下拉刷新高度
            swipes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    handler.sendEmptyMessageDelayed(0, 3000);
                }
            });

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            adapter = new ShopAdapter(context);
        }
    }

    @Override
    public void onSuccess(ShopBean.DatasBean data) {
        System.out.println("数量+++++++++++++++++" + data.getCart_list().size());

        if (data.getCart_list().size() == 0) {
            ll.setVisibility(View.GONE);
            swipes.setVisibility(View.GONE);
            shopitemnull.setVisibility(View.VISIBLE);
            shopitemnull.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            });

        } else if (data.getCart_list().size() > 0) {
            goods_list.clear();

            for (int i = 0; i < data.getCart_list().size(); i++) {
                List<ShopBean.DatasBean.CartListBean.GoodsBean> goods = data.getCart_list().get(i).getGoods();
                for (int j = 0; j < goods.size(); j++) {
                    goods_list.add(goods.get(j));
                }
            }


            ll.setVisibility(View.VISIBLE);
            swipes.setVisibility(View.VISIBLE);
            shopitemnull.setVisibility(View.GONE);
            adapter.chuan(goods_list);
            adapter.setShopOnClickListener(ShopFragment.this);
            recyclerView.setAdapter(adapter);
            nums = data.getCart_count();
            totals = Float.parseFloat(data.getSum());
            String info2 = "共 <font color='#FF5001'>" + nums + "</font> 件商品，";
            info2 += "合计 <font color='#FF5001'>" + totals + "</font> 元";
            shoptext.setText(Html.fromHtml(info2));
            //结算
            showbuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //还需要一个请求数据接口
                    Toast.makeText(context, "结算", Toast.LENGTH_SHORT).show();

//                    Intent intent = new Intent(context, OrderActivity.class);
//                    startActivity(intent);
                }
            });


        }

    }

    @Override
    void initData() {
        if (sp.getBoolean("typetoken", false)) {
            shopPresenter = new ShopPresenter();
            shopPresenter.setViews(this);
            OkHttpClientManager.Param param = new OkHttpClientManager.Param("key", sp.getString("key", ""));
            System.out.println("key+++++++++++++++++++" + sp.getString("key", ""));
            shopPresenter.loadshop(BaseNet.LINK_MOBILE_CART, param);
        }
    }

    @Override
    public void OnRemovesuccess(ShopDeleteBean data, int position) {
        System.out.println("data" + data.getCode());

        if (data.getCode() == 200) {
            goods_list.remove(position);
            adapter.notifyDataSetChanged();
            nums = 0;
            totals = 0.00f;
            OkHttpClientManager.Param param = new OkHttpClientManager.Param("key", sp.getString("key", ""));
            System.out.println("key++++++++++++" + sp.getString("key", ""));
            shopPresenter.loadshop(BaseNet.LINK_MOBILE_CART, param);
        }
    }


    //加
    @Override
    public void OnJiaPrice(float price) {
        nums++;
        totals = totals + price;
        String info2 = "共 <font color='#FF5001'>" + nums + "</font> 件商品，";
        info2 += "合计 <font color='#FF5001'>" + totals + "</font> 元";
        shoptext.setText(Html.fromHtml(info2));
    }

    //减
    @Override
    public void OnJianPrice(float price) {
        nums--;
        totals = totals - price;
        String info2 = "共 <font color='#FF5001'>" + nums + "</font> 件商品，";
        info2 += "合计 <font color='#FF5001'>" + totals + "</font> 元";
        shoptext.setText(Html.fromHtml(info2));
    }

    //删除
    @Override
    public void OnRemove(final String cart_id, final int position) {
//        删除要dialog
        System.out.println("card_id++++++++++++++++" + cart_id);
        dialog = new AlertDialog.Builder(context).create();

        View v = View.inflate(context, R.layout.shop_delete_item, null);
        Button shop_false = (Button) v.findViewById(R.id.shop_delete_false);
        Button shop_true = (Button) v.findViewById(R.id.shop_delete_true);
        dialog.setView(v);
        //设置点击空白对话框不会消失
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        shop_false.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        shop_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClientManager.Param param1 = new OkHttpClientManager.Param("key", sp.getString("key", ""));
                OkHttpClientManager.Param param2 = new OkHttpClientManager.Param("cart_id", cart_id);
                OkHttpClientManager.Param[] param = new OkHttpClientManager.Param[]{param1, param2};
                shopPresenter.deleteshop(BaseNet.LINK_MOBILE_CART_DEL, param, position);
                dialog.cancel();
            }
        });

    }


}
