package com.bawie.bawiestore.model.api_net;

import android.content.SharedPreferences;

/**
 * 网络接口
 * 创建人 dongyulong
 * 创建时间 2016/12/30  9:59.
 */

public class BaseNet {
    //    public static final String SYSTEM_TYPE = "android";
    //    public static final String SYSTEM_VERSION = "V1.0";
//        public static final String SYSTEM_SHARE_NAME = "Yokey_Nsg";

//    public static final String LINK_MAIN = "http://192.168.43.62/";
    public static final String LINK_MAIN = "http://169.254.38.114/";
    public static final String LINK_WAP = LINK_MAIN + "wap/";
    public static final String LINK_WAP_FIND_PASSWORD = LINK_WAP + "tmpl/member/find_password.html";
    public static final String LINK_MOBILE = LINK_MAIN + "mobile/index.php?act=";
    //分类 GET
    //    "http://169.254.38.114/mobile/index.php?act=goods_class"
    public static final String LINK_MOBILE_CLASS = LINK_MOBILE + "goods_class";
    //分类页面右侧
    //    http://169.254.38.114/mobile/index.php?act=goods_class&gc_id=530
    public static final String LINK_MOBILE_CLASS_RIGHT = LINK_MOBILE_CLASS + "&gc_id=";
    //首页 GET
    //  http://169.254.38.114/mobile/index.php?act=index
    public static final String LINK_MOBILE_INDEX = LINK_MOBILE + "index";


    //分类列表页
    //    http://169.254.38.114/mobile/index.php?act=goods&op=goods_list&page=100&key=1&gc_id=
    public static final String LINK_MOBILE_GOODS_LIST = LINK_MOBILE + "goods&op=goods_list&page=100&key=1&gc_id=";
    //分类详情页
    //  http://169.254.38.114/mobile/index.php?act=goods&op=goods_detail&goods_id=
    public static final String LINK_MOBILE_GOODS_DETAIL = LINK_MOBILE + "goods&op=goods_detail&goods_id=";
    //加入购物车（post）
    //http://169.254.38.114/mobile/index.php?act=member_cart&op=cart_add   key,goods_id ,quantity
    public static final String LINK_MOBILE_CART_ADD = LINK_MOBILE + "member_cart&op=cart_add";

    //登录页面(post)
    //http://169.254.38.114/mobile/index.php?act=login   username,password,client = android
    public static final String LINK_MOBILE_LOGIN = LINK_MOBILE+"login";

    //注册页面（post）
    //http://169.254.38.114/mobile/index.php?act=login&op=register   username，password,password_confirm,email,client=android
    public static final String LINK_MOBILE_REGIST = LINK_MOBILE + "login&op=register";
    //购物车页面(post)
    //http://169.254.38.114/mobile/index.php?act=member_cart&op=cart_list  key
    public static final String LINK_MOBILE_CART = LINK_MOBILE + "member_cart&op=cart_list";
    //购物车删除选项页面(post)
    //http://169.254.38.114/mobile/index.php?act=member_cart&op=cart_del  key  cart_id
    public static final String LINK_MOBILE_CART_DEL = LINK_MOBILE + "member_cart&op=cart_del";
}
