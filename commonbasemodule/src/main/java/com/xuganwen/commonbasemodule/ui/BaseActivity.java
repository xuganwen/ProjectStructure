package com.xuganwen.commonbasemodule.ui;

import android.os.Bundle;
import android.view.WindowManager;

import com.gyf.immersionbar.ImmersionBar;
import com.xuganwen.commonbasemodule.R;

import androidx.annotation.CheckResult;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * 文件描述:
 * 作者: 徐干稳
 * 创建日期: 2020/10/25 14:10
 * 版本 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {


    private ViewDataBinding viewDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);

        if(isReadyImmersive()) {
            ImmersionBar.with(this).init();
        }

        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    /**
     * 是否启用沉浸式  默认开启沉静式  可以继承后改写返回值false
     *
     * 获取沉浸式开启状态可以通过 isImmersive()方法获取，该方法由沉静式框架提供
     * */
    protected  boolean isReadyImmersive(){
        return true;
    }

    /**
     * 获取文件方法，必须要重写该方法，以让布局正常加载
     * */
    public abstract int getLayoutId();


}
