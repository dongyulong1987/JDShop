package com.bawie.bawiestore.views.interfaces;

import com.bawie.bawiestore.model.bean.LoginBean;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/12  14:00.
 */

public interface LoginViews extends BaseViews {
        void onSuccess(LoginBean loginBean);
}
