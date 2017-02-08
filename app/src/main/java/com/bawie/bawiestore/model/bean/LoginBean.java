package com.bawie.bawiestore.model.bean;

/**
 * 登录成功实体类
 * 创建人 dongyulong
 * 创建时间 2017/1/13  14:19.
 */

public class LoginBean {

    /**
     * code : 200
     * datas : {"key":"62882c6803e08365efc9a56b74cea4af","userid":"2","username":"dyl125396357"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * key : 62882c6803e08365efc9a56b74cea4af
         * userid : 2
         * username : dyl125396357
         */

        private String key;
        private String userid;
        private String username;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
