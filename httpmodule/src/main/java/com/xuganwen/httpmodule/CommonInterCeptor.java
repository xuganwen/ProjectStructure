package com.xuganwen.httpmodule;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 文件描述:okhttp过滤器
 * 作者: 徐干稳
 * 创建日期: 2020/07/20 19:09
 * 版本 1.0
 */
public class CommonInterCeptor implements Interceptor {

    private CommonInterCeptor() {

    }

    protected static CommonInterCeptor create() {
         return new CommonInterCeptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

       /*  request=request.newBuilder().addHeader("Content-Type", "text/html; charset=UTF-8")
                 .addHeader("Content-Type", "text/html; charset=gb2312")
                 .build();*/
        Response proceed = chain.proceed(request);


        return proceed;
    }

}
