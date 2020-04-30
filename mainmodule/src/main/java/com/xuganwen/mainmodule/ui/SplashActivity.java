package com.xuganwen.mainmodule.ui;

import android.os.Bundle;

import com.xuganwen.mainmodule.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 文件描述:  app欢迎页
 * 作者: 徐干稳
 * 创建日期: 2020/03/31 17:42
 * 版本 1.0
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_layout_splash);

    }
}
