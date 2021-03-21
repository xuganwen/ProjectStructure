package com.xuganwen.httpmodule;

import android.text.TextUtils;

import com.xuganwen.utilmodule.GsonUtil;
import com.xuganwen.utilmodule.SpUtil;
import com.xuganwen.utilmodule.ToastUtil;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文件描述:
 * 作者: 徐干稳
 * 创建日期: 2020/07/20 19:02
 * 版本 1.0
 */
public class HttpManager {

    private static HttpManager manager = null;
    private static Retrofit retrofit;

    private static OkHttpClient client;

    private static long READ_TIME_OUT = 10000;

    private static long WRITE_TIME_OUT = 10000;

    private static long CONNECTION_TIME_OUT = 10000;

    public static String BASEURL = BuildConfig.ADDRESS_IP;


    /**
     * 床架带有json字符串的boday
     *
     * @param params
     * @return
     */
    public static RequestBody createJsonBody(Map<String, Object> params) {
        RequestBody requestBody = RequestBody
                .create(MediaType.get("application/json"), GsonUtil.toJson(params));
        return requestBody;
    }

    public static RequestBody createJsonBody(Object object) {
        RequestBody requestBody = RequestBody
                .create(MediaType.get("application/json"), GsonUtil.toJson(object));
        return requestBody;
    }

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
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .baseUrl(BASEURL)
                    .client(client)
                    .build();

    }

    public static HttpManager getHttpManager() {
        if (null == manager) {
            synchronized (HttpManager.class) {
                manager = new HttpManager();
            }
            return manager;
        }
        return manager;
    }

    public <T extends APIService>  T getService(Class t) {
        Objects.requireNonNull(retrofit, "retrofit init failed,please check");

        return (T)retrofit.create(t);
    }
}
