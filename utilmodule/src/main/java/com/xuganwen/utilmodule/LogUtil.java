package com.xuganwen.utilmodule;

import android.util.Log;

/**
 * 文件描述:
 * 作者: 徐干稳
 * 创建日期: 2020/10/09 21:35
 * 版本 1.0
 */
public class LogUtil {

    public static String TAG_GSON="gsonLog";

    public static void e(String tag,String message){
        if(BuildConfig.DEBUG){
            Log.e(tag, message);
        }
    }
}
