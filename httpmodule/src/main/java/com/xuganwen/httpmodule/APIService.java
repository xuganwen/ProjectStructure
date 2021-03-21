package com.xuganwen.httpmodule;


import java.util.Map;

import io.reactivex.rxjava3.core.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 文件描述:
 * 作者: 徐干稳
 * 创建日期: 2021/03/20 18:33
 * 版本 1.0
 */
public interface APIService {

    @GET("/iot/getDeviceList")
    Flowable<ResponseBody> getHomeList(@QueryMap Map<String, Object> params);

    @GET("/iot/getDevicePropertyDataList")
    Flowable<ResponseBody> getDetailInfo(@QueryMap Map<String, Object> map);
}
