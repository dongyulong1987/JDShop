package com.bawie.bawiestore.views.interfaces;

import com.bawie.bawiestore.model.bean.CategeryBean;
import com.bawie.bawiestore.model.bean.CategeryRightTextBean;

import java.util.List;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/2  20:45.
 */

public interface CategeryRightTextView extends BaseViews {
    void onSuccess(CategeryRightTextBean.DatasBean datasBean,List<CategeryRightTextBean.DatasBean.ClassListBean> list);
    void onSuccesses(CategeryRightTextBean.DatasBean datasBean,List<CategeryRightTextBean.DatasBean.ClassListBean> list);
}
