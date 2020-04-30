package com.xuganwen.commonbasemodule.database.dao;

import com.xuganwen.commonbasemodule.bean.UserInfo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * 文件描述:
 * 作者: 徐干稳
 * 创建日期: 2020/04/02 10:46
 * 版本 1.0
 */
@Dao
public interface UserDao {

    @Query("Select * from UserInfo")
    List<UserInfo> getListData();

    @Update
    int updateUser(UserInfo userInfo);

    @Delete
    int deleteUser(UserInfo userInfo);

    @Insert
    void addUser(UserInfo userInfo);
}
