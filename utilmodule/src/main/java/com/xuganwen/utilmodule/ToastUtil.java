package com.xuganwen.utilmodule;

import android.widget.Toast;

import com.xuganwen.mainmodule.MyApplication;

/**
 * 文件描述:  吐司提示工具类
 * 作者: 徐干稳
 * 创建日期: 2020/04/01 8:25
 * 版本 1.0
 */
public class ToastUtil {

    public static void showToastShort(String toastString) {
        Toast.makeText(MyApplication.getAppInstance(), null == toastString ? "缺少提示语" : toastString, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(String toastString) {
        Toast.makeText(MyApplication.getAppInstance(), null == toastString ? "缺少提示语" : toastString, Toast.LENGTH_LONG).show();
    }


}
