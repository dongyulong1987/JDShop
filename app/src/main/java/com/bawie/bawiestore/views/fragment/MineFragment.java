package com.bawie.bawiestore.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawie.bawiestore.R;
import com.bawie.bawiestore.views.activity.LoginActivity;
import com.bawie.bawiestore.views.activity.UnLoginActivity;
import com.bawie.bawiestore.views.interfaces.MineView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 创建人 dongyulong
 * 创建时间 2016/12/28  14:05.
 */

public class MineFragment extends BaseFragment implements MineView {


    @BindView(R.id.mime_photo)
    ImageView mimePhoto;
    @BindView(R.id.tv_login_register)
    TextView tvLoginRegister;
    @BindView(R.id.tv_mime_setting)
    ImageView tvMimeSetting;
    @BindView(R.id.mime_massage)
    ImageView mimeMassage;
    @BindView(R.id.tv_goods_collection)
    TextView tvGoodsCollection;
    @BindView(R.id.tv_shop_collection)
    TextView tvShopCollection;
    @BindView(R.id.tv_my_foot)
    TextView tvMyFoot;
    @BindView(R.id.relative1)
    RelativeLayout relative1;
    @BindView(R.id.ll_allorder)
    LinearLayout llAllorder;
    @BindView(R.id.tv_wait_pay)
    TextView tvWaitPay;
    @BindView(R.id.tv_wait_drive)
    TextView tvWaitDrive;
    @BindView(R.id.tv_wait_receipt)
    TextView tvWaitReceipt;
    @BindView(R.id.tv_wait_comment)
    TextView tvWaitComment;
    @BindView(R.id.tv_wait_refund)
    TextView tvWaitRefund;
    @BindView(R.id.ll_mymoney)
    LinearLayout llMymoney;
    @BindView(R.id.tv_property_money)
    TextView tvPropertyMoney;
    @BindView(R.id.tv_property_card)
    TextView tvPropertyCard;
    @BindView(R.id.tv_property_vouchers)
    TextView tvPropertyVouchers;
    @BindView(R.id.tv_property_red)
    TextView tvPropertyRed;
    @BindView(R.id.tv_property_integral)
    TextView tvPropertyIntegral;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.ll_setting)
    LinearLayout llSetting;
    Unbinder unbinder;
    private Intent intent;
    private Intent intent1;

    @Override
    View initSelfview() {
        View v = View.inflate(getActivity(), R.layout.minefragment, null);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        System.out.println("username++++++++++++"+sp.getString("username","点击登录"));

        tvLoginRegister.setText(sp.getString("username", "点击登录"));
        if (sp.getBoolean("typetoken",false)) {
            intent1 = new Intent(context,UnLoginActivity.class);
        } else {
            intent = new Intent(context, LoginActivity.class);
        }
    }

    //初始化控件
    @Override
    void initView(View view) {
        System.out.println("initView++++++++++");

    }

    //调用P层请求网络
    @Override
    void initData() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mime_photo, R.id.tv_login_register, R.id.tv_mime_setting, R.id.mime_massage, R.id.tv_goods_collection, R.id.tv_shop_collection, R.id.tv_my_foot, R.id.relative1, R.id.ll_allorder, R.id.tv_wait_pay, R.id.tv_wait_drive, R.id.tv_wait_receipt, R.id.tv_wait_comment, R.id.tv_wait_refund, R.id.ll_mymoney, R.id.tv_property_money, R.id.tv_property_card, R.id.tv_property_vouchers, R.id.tv_property_red, R.id.tv_property_integral, R.id.ll_address, R.id.ll_setting})
    public void onClick(View view) {
        if (sp.getBoolean("typetoken",false)) {
            switch (view.getId()) {
                case R.id.mime_photo:
                    startActivity(intent1);
                    break;
                case R.id.tv_login_register:

                    startActivity(intent1);

                    break;
                case R.id.tv_mime_setting:
                    break;
                case R.id.mime_massage:
                    break;
                case R.id.tv_goods_collection:
                    break;
                case R.id.tv_shop_collection:
                    break;
                case R.id.tv_my_foot:
                    break;
                case R.id.relative1:
                    break;
                case R.id.ll_allorder:
                    break;
                case R.id.tv_wait_pay:
                    break;
                case R.id.tv_wait_drive:
                    break;
                case R.id.tv_wait_receipt:
                    break;
                case R.id.tv_wait_comment:
                    break;
                case R.id.tv_wait_refund:
                    break;
                case R.id.ll_mymoney:
                    break;
                case R.id.tv_property_money:
                    break;
                case R.id.tv_property_card:
                    break;
                case R.id.tv_property_vouchers:
                    break;
                case R.id.tv_property_red:
                    break;
                case R.id.tv_property_integral:
                    break;
                case R.id.ll_address:
                    break;
                case R.id.ll_setting:
                    break;
            }
        }else{
            switch (view.getId()) {
                case R.id.mime_photo:

                    startActivity(intent);
                    break;
                case R.id.tv_login_register:

                    startActivity(intent);
                    break;
                case R.id.tv_mime_setting:
                    startActivity(intent);
                    break;
                case R.id.mime_massage:
                    startActivity(intent);
                    break;
                case R.id.tv_goods_collection:
                    startActivity(intent);
                    break;
                case R.id.tv_shop_collection:
                    startActivity(intent);
                    break;
                case R.id.tv_my_foot:
                    startActivity(intent);
                    break;
                case R.id.relative1:
                    startActivity(intent);
                    break;
                case R.id.ll_allorder:
                    startActivity(intent);
                    break;
                case R.id.tv_wait_pay:
                    startActivity(intent);
                    break;
                case R.id.tv_wait_drive:
                    startActivity(intent);
                    break;
                case R.id.tv_wait_receipt:
                    startActivity(intent);
                    break;
                case R.id.tv_wait_comment:
                    startActivity(intent);
                    break;
                case R.id.tv_wait_refund:
                    startActivity(intent);
                    break;
                case R.id.ll_mymoney:
                    startActivity(intent);
                    break;
                case R.id.tv_property_money:
                    startActivity(intent);
                    break;
                case R.id.tv_property_card:
                    startActivity(intent);
                    break;
                case R.id.tv_property_vouchers:
                    startActivity(intent);
                    break;
                case R.id.tv_property_red:
                    startActivity(intent);
                    break;
                case R.id.tv_property_integral:
                    startActivity(intent);
                    break;
                case R.id.ll_address:
                    startActivity(intent);
                    break;
                case R.id.ll_setting:
                    startActivity(intent);
                    break;
            }

        }
    }
}
