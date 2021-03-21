package com.xuganwen.commonbasemodule.database;

import com.xuganwen.commonbasemodule.bean.UserInfo;
import com.xuganwen.commonbasemodule.database.dao.UserDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * 文件描述:
 * 作者: 徐干稳
 * 创建日期: 2020/04/02 10:32
 * 版本 1.0
 */
@Database(entities = {UserInfo.class}, version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {


    public static  int DB_LOCAL_VERSION=1;

    public static  int DB_LOCAL_VERSION_NEW=1;

    static String UpGradeSQL = "CREATE TABLE `Fruit` (`FruitId` INTEGER NOT NULL, "
            + "`FruitName` TEXT, PRIMARY KEY(`FruitId`))";
//     升级数据库的方法 -- 当前为从 版本1 升级到 版本2
    public static final Migration MIGRATION= new Migration(DB_LOCAL_VERSION, DB_LOCAL_VERSION_NEW) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 因为表没有发生变化，所以这里什么也不做
            database.execSQL(UpGradeSQL);

        }
    };

    public abstract UserDao getUserDao();


}
