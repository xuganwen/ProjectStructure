package com.xuganwen.commonbasemodule.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;

/**
 * 文件描述: fragment基类
 * 作者: 徐干稳
 * 创建日期: 2020/10/26 21:11
 * 版本 1.0
 */
public abstract class BaseFragment extends Fragment   implements LifecycleObserver {

    private ViewBinding fragmentRootBinding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentRootBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);

        return fragmentRootBinding.getRoot();
    }

    public abstract int getLayoutId();


    /**
     * 获取网络数据
     * */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public abstract void getNetData();
}
