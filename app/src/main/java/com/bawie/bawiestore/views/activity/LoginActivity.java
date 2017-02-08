package com.bawie.bawiestore.views.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.api_net.BaseNet;
import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.LoginBean;
import com.bawie.bawiestore.presenter.LoginPresenter;
import com.bawie.bawiestore.views.interfaces.LoginViews;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录界面
 * 创建人 dongyulong
 * 创建时间 2017/1/12  9:35.
 */

public class LoginActivity extends BaseActivity implements LoginViews {
    @BindView(R.id.login_return_bun)
    ImageView loginReturnBun;
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_pass)
    EditText loginPass;
    @BindView(R.id.login_bun)
    Button loginBun;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.login_find_pwd)
    TextView loginFindPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layut);
        ButterKnife.bind(this);
    }

    //网络请求调用P层
    @Override
    void initDatass() {

    }

    @OnClick({R.id.login_return_bun, R.id.login_bun, R.id.login_register, R.id.login_find_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_return_bun:
                finish();
                break;
            case R.id.login_bun:
                String name = loginName.getText().toString().trim();
                String pass = loginPass.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
                    Toast.makeText(myApplication, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    OkHttpClientManager.Param param1 = new OkHttpClientManager.Param("username", name);
                    OkHttpClientManager.Param param2 = new OkHttpClientManager.Param("password", pass);
                    OkHttpClientManager.Param param3 = new OkHttpClientManager.Param("client", "android");
                    OkHttpClientManager.Param param[] = new OkHttpClientManager.Param[]{param1, param2, param3};
                    LoginPresenter loginPresenter = new LoginPresenter();
                    loginPresenter.setViews(this);
                    loginPresenter.loadLogin(BaseNet.LINK_MOBILE_LOGIN, param);
                    
                }


                break;
            case R.id.login_register:
                Intent intent = new Intent(myApplication, RegistActivity.class);
                startActivity(intent);

                break;
            case R.id.login_find_pwd:
                Toast.makeText(myApplication, "暂未开放", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //登录成功或失败
    @Override
    public void onSuccess(LoginBean loginBean) {
        if (loginBean.getCode() == 200) {
            sp.edit().putBoolean("typetoken", true).commit();
            sp.edit().putString("username", loginBean.getDatas().getUsername()).commit();
            sp.edit().putString("userid", loginBean.getDatas().getUserid()).commit();
            sp.edit().putString("key", loginBean.getDatas().getKey()).commit();


            finish();
            Toast.makeText(myApplication, "登录成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(myApplication, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}
