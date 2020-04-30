package com.xuganwen.commonbasemodule.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 文件描述:  用户类
 * 作者: 徐干稳
 * 创建日期: 2020/04/02 10:57
 * 版本 1.0
 */
@Entity
public class UserInfo {

    @PrimaryKey
    public Integer id;

    public String userName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
