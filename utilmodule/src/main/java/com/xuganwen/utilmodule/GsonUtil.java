package com.xuganwen.utilmodule;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * 文件描述:  Json转换工具类
 * 作者: 徐干稳
 * 创建日期: 2020/10/09 20:23
 * 版本 1.0
 */
public class GsonUtil {

    private static Gson gson;

    static {
        gson = new GsonBuilder().serializeNulls().create();
    }


    /**
     * @param object 将object对象转换成json字符串
     */
    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    /**
     * @param jsonString json字符串
     * @param tClass     解析模板类类型
     */
    public static <T> T fromJson(String jsonString, Class<T> tClass) {
        try {
            return gson.fromJson(jsonString, tClass);
        } catch (Exception exception) {
            LogUtil.e(LogUtil.TAG_GSON,exception.getMessage());
        } finally {
            ToastUtil.showToastShort("json解析失败");
        }
        return null;
    }


    /**
     * 用法诸如
     *
     * @param tClass (Type)Person.class
     */
    public static <T> T fromJson(String jsonString, Type tClass) {
        try {
            return gson.fromJson(jsonString, tClass);
        } catch (Exception exception) {
            LogUtil.e(LogUtil.TAG_GSON,exception.getMessage());
        } finally {
            ToastUtil.showToastShort("json解析失败");
        }
        return null;
    }
}
