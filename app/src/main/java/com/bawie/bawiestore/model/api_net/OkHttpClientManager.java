package com.bawie.bawiestore.model.api_net;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;


import java.io.IOException;





public class OkHttpClientManager {


        private static OkHttpClientManager mOkHttpUtil;
        private Gson mGson;
        private Handler mHandler;
        private OkHttpClient mOkHttpClient;

        private OkHttpClientManager(){
            //实例化Gson
            mGson = new Gson();
            //实例化主线程的Handler
            mHandler = new Handler(Looper.getMainLooper());
            //实例化OkHttpClient
            mOkHttpClient = new OkHttpClient();
        }

        public static OkHttpClientManager getInstance(){
            if(mOkHttpUtil == null){
                synchronized (OkHttpClientManager.class){
                    if(mOkHttpUtil == null){
                        mOkHttpUtil = new OkHttpClientManager();
                    }
                }
            }
            return mOkHttpUtil;
        }

        /**
         *
         * get请求
         *
         * @param url  请求的Url
         * @param clazz  实体Bean
         * @param callBack 回调接口
         * @param <T> Bean类型
         */
        public <T>void requestJson2Bean(String url, final Class<T> clazz,
                                        final RequestJson2BeanCallBack<T> callBack){
            //实例化Request
            Request request = new Request.Builder().url(url).build();
            Log.d("TAG",url);
            //请求网络
            mOkHttpClient.newCall(request).enqueue(new Callback() {
               @Override
                public void onFailure(Request request, IOException e) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //回调失败的方法
                            callBack.error();
                        }
                    });
                }
                @Override
                public void onResponse(Response response) throws IOException {
                    //得到json串
                    String json = response.body().string();
                    final T result = mGson.fromJson(json, clazz);
                    //转换到主线程回调接口
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //回调成功的方法
                            callBack.success(result);
                        }
                    });
                }
            });
        }

        /**
         *
         *post请求
         *
         * @param url 请求的Url
         * @param callBack 回调借口  OkHttp默认为子线程已更换为主线程 可在回调的方法中直接更新UI
         * @param param 参数对象
         * @param <T> Bean类型
         */
        public <T>void requestJson2Bean(String url, final Class<T> clazz ,
                                        final RequestJson2BeanCallBack<T> callBack, Param... param){
            //调用自定义封装方法 该方法将请求参数封装到Request对象中 并返回
            Request request = builderPostRequest(url,param);
            //请求数据
            mOkHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    //回调失败的方法
                    callBack.error();
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    //得到json串
                    String json = response.body().string();
                    final T result = mGson.fromJson(json, clazz);
                    //转换到主线程
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //回调成功的方法
                            callBack.success(result);
                        }
                    });
                }
            });
        }

        /**
         *
         * @param url 请求的Url
         * @param params post请求的参数  存储在对象中
         * @return 封装好的Request对象
         */
        private Request builderPostRequest(String url, Param[] params) {
            //实例化FormEncodingBuilder对象
            FormEncodingBuilder builder = new FormEncodingBuilder();
            //对请求参数进行判空
            if(params == null){
                params = new Param[0];
            }
            for(Param param : params){
                builder.add(param.key,param.value);
            }
            RequestBody requestBody = builder.build();
            //创建Request对象
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            return request;
        }

        public interface  RequestJson2BeanCallBack <T>{
            void success(T result);
            void error();
        }

        //自定义存储类 存储类型为键值对 用于Post请求
        public static class Param{
            public String key;
            public String value;

            public Param() {
            }

            public Param(String key, String value) {

                this.key = key;
                this.value = value;
            }
        }





}