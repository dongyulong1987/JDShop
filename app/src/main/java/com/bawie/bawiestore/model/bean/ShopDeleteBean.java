package com.bawie.bawiestore.model.bean;

/**
 * 删除商品的实体类
 * 创建人 dongyulong
 * 创建时间 2017/1/30  18:03.
 */

public class ShopDeleteBean extends BaseBean {
    /**
     * code : 200
     * datas : 1
     */
    private int code;
    private String datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }

}
