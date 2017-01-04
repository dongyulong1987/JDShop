package com.bawie.bawiestore.model.bean;

import java.util.List;

/**
 * 创建人 dongyulong
 * 创建时间 2017/1/2  20:32.
 */

public class CategeryRightTextBean {

    /**
     * code : 200
     * datas : {"class_list":[{"gc_id":"531","gc_name":"时尚饰品"},{"gc_id":"532","gc_name":"纯金K金饰品"},{"gc_id":"533","gc_name":"金银投资"},{"gc_id":"534","gc_name":"银饰"},{"gc_id":"535","gc_name":"钻石饰品"},{"gc_id":"536","gc_name":"翡翠玉石"},{"gc_id":"537","gc_name":"水晶玛瑙"},{"gc_id":"538","gc_name":"宝石珍珠"},{"gc_id":"539","gc_name":"婚庆"},{"gc_id":"540","gc_name":"钟表手表"}]}
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
        private List<ClassListBean> class_list;

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class ClassListBean {
            /**
             * gc_id : 531
             * gc_name : 时尚饰品
             */

            private String gc_id;
            private String gc_name;

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getGc_name() {
                return gc_name;
            }

            public void setGc_name(String gc_name) {
                this.gc_name = gc_name;
            }
        }
    }
}
