package com.xuganwen.commonbasemodule;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.xuganwen.commonbasemodule.database.DBUtil;


/**
 * 文件名 MyApplication  全局应用类
 * 文件描述
 * 作者 徐干稳
 * 创建日期 2020/03/31 17:20
 * 版本 1.0
 */
public class MyApplication extends Application {

    private static MyApplication appInstance=null;


    @Override
    public void onCreate() {
        super.onCreate();
        if(null==appInstance){
            appInstance=this;
        }

        DBUtil.initRoomDataBase();
    }


    /**
     *
     * 设置app内部文字不会跟随手机字体设置大小改变而改变
     *
     * BuildConfig.MODIFY_FONT_SIZE  .gradle文件配置项
     * */
    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if(BuildConfig.MODIFY_FONT_SIZE&&res.getConfiguration().fontScale!=1) {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            res.updateConfiguration(configuration, res.getDisplayMetrics());
        }
        return res;
    }

    public static MyApplication getAppInstance() {
        return appInstance;
    }
}
