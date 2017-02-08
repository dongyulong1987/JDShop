package com.bawie.bawiestore.views.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.bawie.bawiestore.R;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/27  22:24.
 */

public class WelcomeActivity extends BaseActivity {
    private TextView textView;
    private SharedPreferences sps;
    private int time = 5;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (time > 0) {
                    time--;
                    handler.sendEmptyMessageDelayed(1, 1000);
                } else if (time == 0) {
                    time = 5;
                    sps = getSharedPreferences("config", MODE_PRIVATE);
                    boolean flag = sps.getBoolean("flag", false);
                    //判断是否是第一次，第一次的话为false,否则为true
                    if (flag) {
                        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        SharedPreferences.Editor ed = sps.edit();
                        ed.putBoolean("flag", true);
                        ed.commit();
                        Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        handler.sendEmptyMessageDelayed(1, 1000);
    }

    @Override
    void initDatass() {

    }

}
