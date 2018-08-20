package com.srx.huangshang.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.common.activity.BaseActivity;
import com.example.common.activity.BaseDataBinDingActivity;
import com.srx.huangshang.R;
import com.srx.huangshang.databinding.ActivityStartBinding;

/**
 * Created by huangweishui on 2018/8/20.
 */

public class StartActivity extends AppCompatActivity {
    private ActivityStartBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding=DataBindingUtil.setContentView(this,getLayoutId());
    }

    public int getLayoutId() {
        return R.layout.activity_start;
    }

    public void initData() {
    }

    public void initView() {
    }

    public void initRequest() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
