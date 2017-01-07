package com.bawie.bawiestore.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.api_net.BaseNet;
import com.bawie.bawiestore.model.bean.ContentBean;
import com.bawie.bawiestore.presenter.ContentPresenter;
import com.bawie.bawiestore.views.adapter.ContentRecycleAdapter;
import com.bawie.bawiestore.views.interfaces.ContentView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 商品详情界面
 * 创建人 dongyulong
 * 创建时间 2017/1/4  19:04.
 */

public class ContentActivity extends BaseActivity implements ContentView{
    //左上角返回按钮
    @BindView(R.id.cont_left_bun)
    Button contLeftBun;
    //顶部编辑框
    @BindView(R.id.cont_edit)
    EditText contEdit;
    //右侧搜索
    @BindView(R.id.cont_right_bun)
    Button contRightBun;
    //综合排序
    @BindView(R.id.cont_paixu)
    TextView contPaixu;
    //销量优先
    @BindView(R.id.cont_sell)
    TextView contSell;
    //筛选
    @BindView(R.id.cont_choice)
    TextView contChoice;
    //recycle布局
    @BindView(R.id.cont_recycle)
    RecyclerView contRecycle;
    private String gc_id;
    private ContentRecycleAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        gc_id = intent.getStringExtra("gc_id");
        System.out.println("++++++++++++++++++++++"+gc_id);
        //设置管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        contRecycle.setLayoutManager(linearLayoutManager);
        adapter = new ContentRecycleAdapter(this);
        initData();
        contLeftBun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    //调P层请求网络

   public  void initData() {
        ContentPresenter contentPresenter = new ContentPresenter();
        contentPresenter.setViews(this);
        contentPresenter.loadContent(BaseNet.LINK_MOBILE_GOODS_LIST+gc_id);
    }

    @Override
    public void onSuccess(ContentBean.DatasBean datas) {
        if(datas.getGoods_list().size()>0){
            adapter.byValue(datas.getGoods_list());
            contRecycle.setAdapter(adapter);
            adapter.setOnItemClickListener(new ContentRecycleAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view, ContentBean.DatasBean.GoodsListBean data) {
                    String goods_id = data.getGoods_id();
                    Intent intent = new Intent(ContentActivity.this,ContentdetailsActivity.class);
                    intent.putExtra("goods_id",goods_id);
                    startActivity(intent);
                }
            });
        }

    }
}
