package com.xuganwen.commonbasemodule;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.xuganwen.commonbasemodule.database.DBUtil;


/**
 * 文件名 MyApplication  全局应用类
 * 文件描述
 * 作者 徐干稳
 * 创建日期 2020/03/31 17:20
 * 版本 1.0
 */
public class MyApplication extends Application {

    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.color_blue, android.R.color.white);//全局设置主题颜色
                return new MaterialHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        /*//设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });*/
    }


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
     * 设置app内部文字不会跟随手机字体设置大小改变而改变
     * BuildConfig.MODIFY_FONT_SIZE  .gradle文件配置项
     *
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
