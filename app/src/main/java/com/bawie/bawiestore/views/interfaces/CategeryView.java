package com.bawie.bawiestore.views.interfaces;

import com.bawie.bawiestore.model.bean.BaseBean;
import com.bawie.bawiestore.model.bean.CategeryBean;

/**
 * 分类界面接口
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:09.
 */

public interface CategeryView extends BaseViews {
    void onSuccess(CategeryBean.DatasBean datas);
}
