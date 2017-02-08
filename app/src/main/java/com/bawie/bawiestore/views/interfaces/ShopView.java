package com.bawie.bawiestore.views.interfaces;

import com.bawie.bawiestore.model.bean.ShopBean;
import com.bawie.bawiestore.model.bean.ShopDeleteBean;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:09.
 */

public interface ShopView extends BaseViews {
    void onSuccess(ShopBean.DatasBean data);
    void OnRemovesuccess(ShopDeleteBean data,int position);
}
