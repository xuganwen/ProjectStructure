package com.xuganwen.commonbasemodule.database;

import com.xuganwen.commonbasemodule.MyApplication;

import androidx.room.Room;

/**
 * 文件描述:  数据库工具类  选用Room数据库
 * 作者: 徐干稳
 * 创建日期: 2020/04/01 9:14
 * 版本 1.0
 */
public class DBUtil {

    private static MyDataBase myDataBase;


    /**
     * 初始化数据库ROOM
     * */
    public static void initRoomDataBase() {
        if (null == myDataBase) {
            if (MyDataBase.DB_LOCAL_VERSION < MyDataBase.DB_LOCAL_VERSION_NEW) {
                myDataBase = Room.databaseBuilder(MyApplication.getAppInstance(), MyDataBase.class, "ProjectStructure.db").addMigrations(MyDataBase.MIGRATION).build();
            } else {
                myDataBase = Room.databaseBuilder(MyApplication.getAppInstance(), MyDataBase.class, "ProjectStructure.db").build();
            }
        }

    }


}
