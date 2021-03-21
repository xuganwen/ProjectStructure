package com.xuganwen.mainmodule.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.xuganwen.mainmodule.R;

import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

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



        DataBindingUtil.setContentView(this,R.layout.ac_layout_splash_data_binding);




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
