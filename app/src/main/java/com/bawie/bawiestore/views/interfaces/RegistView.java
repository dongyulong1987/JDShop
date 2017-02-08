package com.bawie.bawiestore.views.interfaces;

import com.bawie.bawiestore.model.bean.RegistErrorBean;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/14  10:35.
 */

public interface RegistView extends BaseViews {
     void onSuccess(RegistErrorBean data);
}
