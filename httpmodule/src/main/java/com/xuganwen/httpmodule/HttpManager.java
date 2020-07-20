package com.xuganwen.httpmodule;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.internal.functions.ObjectHelper;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文件描述:
 * 作者: 徐干稳
 * 创建日期: 2020/07/20 19:02
 * 版本 1.0
 */
public class HttpManager {

    private static HttpManager manager = null;
    private  Retrofit retrofit;

    private OkHttpClient client;

    private static long READ_TIME_OUT = 10000;

    private static long WRITE_TIME_OUT = 10000;

    private static long CONNECTION_TIME_OUT = 10000;

    private static String BASEURL=BuildConfig.ADDRESS_IP;

    private HttpManager() {

        client = new OkHttpClient()
                .newBuilder()
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(CommonInterCeptor.create())
                .build();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(CustomConvertFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASEURL)
                .client(client)
                .build();
    }

    public HttpManager getHttpManager() {
        if (null == manager) {
            synchronized (this) {
                manager = new HttpManager();
                return manager;
            }
        }
        return manager;
    }

    public <T> T getService(T t){
        Objects.requireNonNull(retrofit,"retrofit init failed,please check");
        return (T) retrofit.create(t.getClass());
    }
}
