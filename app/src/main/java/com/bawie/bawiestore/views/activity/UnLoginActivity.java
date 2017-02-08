package com.bawie.bawiestore.views.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.interfaces.UnLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注销界面
 * 创建人 dongyulong
 * 创建时间 2017/1/13  15:34.
 */

public class UnLoginActivity extends BaseActivity implements UnLoginView {
    @BindView(R.id.login_return_bun)
    ImageView loginReturnBun;
    @BindView(R.id.unlogin_photo)
    TextView unloginPhoto;
    @BindView(R.id.unlogin_bun)
    Button unloginBun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unlogin_layout);
        ButterKnife.bind(this);

    }

    @Override
    void initDatass() {

    }

    @OnClick({R.id.login_return_bun, R.id.unlogin_photo, R.id.unlogin_bun})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_return_bun:
                finish();
                break;
            case R.id.unlogin_photo:
                break;
            case R.id.unlogin_bun:
                final AlertDialog.Builder builder = new AlertDialog.Builder(UnLoginActivity.this);

                View v= View.inflate(myApplication,R.layout.unlogin_pop_layout,null);
                TextView queren = (TextView) v.findViewById(R.id.unlogin_queren);
                TextView quxiao = (TextView) v.findViewById(R.id.unlogin_quxiao);

                builder.setView(v);
                final AlertDialog alertDialog =  builder.show();
                queren.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor ed = sp.edit();
                        ed.clear();
                        ed.commit();
                        Toast.makeText(myApplication, "注销成功", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(myApplication,MainActivity.class);
//                        startActivity(intent);
                        alertDialog.dismiss();
                        finish();
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;
        }
    }
}
