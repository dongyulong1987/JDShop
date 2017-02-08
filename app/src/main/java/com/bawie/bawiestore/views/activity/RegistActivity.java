package com.bawie.bawiestore.views.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.model.api_net.BaseNet;
import com.bawie.bawiestore.model.api_net.OkHttpClientManager;
import com.bawie.bawiestore.model.bean.RegistErrorBean;
import com.bawie.bawiestore.presenter.RegistPresenter;
import com.bawie.bawiestore.views.interfaces.RegistView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册界面
 * 创建人 dongyulong
 * 创建时间 2017/1/13  10:29.
 */

public class RegistActivity extends BaseActivity implements RegistView {


    @BindView(R.id.regist_return_bun)
    ImageView registReturnBun;
    @BindView(R.id.regist_name)
    EditText registName;
    @BindView(R.id.regist_pass)
    EditText registPass;
    @BindView(R.id.regist_passtwo)
    EditText registPasstwo;
    @BindView(R.id.regist_email)
    EditText registEmail;
    @BindView(R.id.regist_bun)
    Button registBun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist_layout);
        ButterKnife.bind(this);
    }

    @Override
    void initDatass() {
        

    }
    public  boolean isEmailAddress(String url) {
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(url);
        return matcher.matches();
    }

    @OnClick({R.id.regist_return_bun, R.id.regist_bun})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regist_return_bun:
                finish();
                break;
            case R.id.regist_bun:
                String username = registName.getText().toString().trim();
                String password = registPass.getText().toString().trim();
                String passtwo = registPasstwo.getText().toString().trim();
                String email = registEmail.getText().toString().trim();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(myApplication, "账号不能为空", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(myApplication, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                if (!TextUtils.isEmpty(password)&&password.length()<6){
                    Toast.makeText(myApplication, "密码长度不能低于6位", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(passtwo)){
                    Toast.makeText(myApplication, "请再次输入密码", Toast.LENGTH_SHORT).show();
                }
                if(!password.equals(passtwo)){
                    Toast.makeText(myApplication, "输入密码不一致", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(myApplication, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    if(!isEmailAddress(email)){
                        Toast.makeText(myApplication, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
                    }
                }
                OkHttpClientManager.Param param1 = new OkHttpClientManager.Param("username",username);
                OkHttpClientManager.Param param2 = new OkHttpClientManager.Param("password",password);
                OkHttpClientManager.Param param3 = new OkHttpClientManager.Param("password_confirm",passtwo);
                OkHttpClientManager.Param param4 = new OkHttpClientManager.Param("email",email);
                OkHttpClientManager.Param param5 = new OkHttpClientManager.Param("client","android");
                OkHttpClientManager.Param[] param = new OkHttpClientManager.Param[]{param1,param2,param3,param4,param5};
                RegistPresenter registPresenter = new RegistPresenter();
                registPresenter.setViews(this);
                registPresenter.loadregist(BaseNet.LINK_MOBILE_REGIST,param);



                break;
        }
    }

    @Override
    public void onSuccess(RegistErrorBean data) {
        if(data.getCode()!=400){
            Toast.makeText(myApplication, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            String error = data.getDatas().getError();
            Toast.makeText(myApplication, error, Toast.LENGTH_SHORT).show();
        }
    }
}
