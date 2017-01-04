package com.bawie.bawiestore.views.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.api_net.BaseNet;
import com.bawie.bawiestore.model.bean.CategeryBean;
import com.bawie.bawiestore.model.bean.CategeryRightTextBean;
import com.bawie.bawiestore.presenter.CategeryPresenter;
import com.bawie.bawiestore.presenter.CategeryRightTextPresenter;
import com.bawie.bawiestore.views.adapter.CategeryAdapter;
import com.bawie.bawiestore.views.adapter.CategeryRightAdapter;
import com.bawie.bawiestore.views.adapter.CategeryRightItemAdapter;
import com.bawie.bawiestore.views.interfaces.CategeryRightTextView;
import com.bawie.bawiestore.views.interfaces.CategeryView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * 分类页面fragment
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:05.
 */

public class CategeryFragment extends BaseFragment implements CategeryView, CategeryRightTextView {

    private int positions = 0;
    private String gcId;
    private ListView listView;
    private RecyclerView recyclerView;
    private CategeryRightItemAdapter adapter1;
    private CategeryRightTextPresenter categeryRightTextPresenter;
    private List<CategeryRightItemAdapter> AList;
    private List<CategeryRightTextBean.DatasBean.ClassListBean> data;
    private int num = 0;
    private int listNum;
    private CategeryRightAdapter rightAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = getActivity();
    }

    @Override
    View initSelfview() {
        return View.inflate(context, R.layout.categeryfragment, null);
    }

    @Override
    void initView(View view) {
        listView = (ListView) view.findViewById(R.id.cate_leftList);
        recyclerView = (RecyclerView) view.findViewById(R.id.cate_rightList);
        AList = new ArrayList<>();
        //线性布局任务管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        //设置方向为竖直方向
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //将管理器绑定到recyclerView上
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    void initData() {
        CategeryPresenter categeryPresenter = new CategeryPresenter();
        categeryPresenter.setViews(this);
        categeryPresenter.loadCategery(BaseNet.LINK_MOBILE_CLASS);
        categeryRightTextPresenter = new CategeryRightTextPresenter();
        categeryRightTextPresenter.setViews(this);
        rightAdapter = new CategeryRightAdapter(context);
        recyclerView.setAdapter(rightAdapter);
    }

    @Override
    public void onSuccess(CategeryBean.DatasBean datas) {
        final List<CategeryRightTextBean.DatasBean.ClassListBean> list = new ArrayList<>();
        final List<CategeryBean.DatasBean.ClassListBean> class_list = datas.getClass_list();
        class_list.get(0).setFlag(true);
        final CategeryAdapter adapter = new CategeryAdapter(context, class_list);
        listView.setAdapter(adapter);
        categeryRightTextPresenter.loadCategeryRightText(BaseNet.LINK_MOBILE_CLASS_RIGHT + class_list.get(0).getGc_id(), list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for (int i = 0; i < class_list.size(); i++) {
                    class_list.get(i).setFlag(false);
                }
                class_list.get(position).setFlag(true);
                adapter.notifyDataSetChanged();
                //清空适配器集合，否则只能保存一遍数据
                if (list != null & list.size() > 0) {
                    list.clear();
                }
                if (AList != null & AList.size() > 0) {
                    AList.clear();
                }
                //点击左侧条目请求右侧数据,不能重复请求数据，当点击的条目已被选中时则不能再次请求数据
                if (positions != position) {
                    gcId = class_list.get(position).getGc_id();
                    categeryRightTextPresenter.loadCategeryRightText(BaseNet.LINK_MOBILE_CLASS_RIGHT + gcId, list);
                    positions = position;
                }

            }
        });
    }

    //右侧textview请求数据成功
    @Override
    public void onSuccess(CategeryRightTextBean.DatasBean datasBean, List<CategeryRightTextBean.DatasBean.ClassListBean> list) {
        list = datasBean.getClass_list();
        listNum = list.size();
        categeryRightTextPresenter.loadCategeryRightGride(BaseNet.LINK_MOBILE_CLASS_RIGHT+list.get(num).getGc_id(),list);
    }

    @Override
    public void onSuccesses(CategeryRightTextBean.DatasBean datasBean, List<CategeryRightTextBean.DatasBean.ClassListBean> list) {
        data = datasBean.getClass_list();
        //GrideView适配器
        adapter1 = new CategeryRightItemAdapter(context, data);
        AList.add(adapter1);
        //num相当于循环的条件这样写可以避免数据混乱
        num++;
        if(num<listNum){
            categeryRightTextPresenter.loadCategeryRightGride(BaseNet.LINK_MOBILE_CLASS_RIGHT+list.get(num).getGc_id(),list);
        }else {
            //RecycleView适配器
            rightAdapter.inda((ArrayList<CategeryRightTextBean.DatasBean.ClassListBean>) list, AList);
            num = 0;
            listNum = 0;
        }
    }


}
