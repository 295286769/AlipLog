package com.aliyun.sls;

import android.app.Application;

import com.aliyun.sls.android.sdk.logutils.AppUtils;

/**
 * Created by huangweishui on 2018/3/23.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.syncIsDebug(this);
    }
}
