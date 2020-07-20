package com.xuganwen.utilmodule;

import android.content.Context;
import android.content.SharedPreferences;

import com.xuganwen.commonbasemodule.MyApplication;

/**
 * 文件描述:SharedPreferences工具类
 * 作者: 徐干稳
 * 创建日期: 2020/04/01 8:24
 * 版本 1.0
 */
public class SpUtil {

    private static String PREFERENCE_FILE_NAME = "myapp_preference";

    private static String PREFERENCE_LABLE_NAME = "name";

    public static SharedPreferences sharedPreferences = MyApplication.getAppInstance().getSharedPreferences(SpUtil.PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);

    /**
     * 保存数据
     */
    public static void saveString(String lableName, String value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(lableName, value);
        edit.apply();
    }

    /**
     * 保存数据
     */
    public static void saveInt(String lableName, int value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(lableName, value);
        edit.apply();
    }


    /**
     * 保存数据
     */
    public static void saveLong(String lableName, Long value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(lableName, value);
        edit.apply();
    }

    /**
     * 保存数据
     */
    public static void saveFloat(String lableName, Float value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putFloat(lableName, value);
        edit.apply();
    }


    /**
     * 保存数据
     */
    public static void saveBoolean(String lableName, boolean value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(lableName, value);
        edit.apply();
    }

    /**
     * 清除数据
     */
    public static void clear(String lableName, String value) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    /**
     * 清除数据
     */
    public static void removeLable(String lableName) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(lableName);
            edit.apply();
        } catch (Exception e) {
            throw new IllegalArgumentException("不存在此lable");
        }
    }


}
