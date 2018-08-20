package com.srx.huangshang;

import android.content.Context;

import com.adhoc.adhocsdk.AdhocTracker;
import com.adhoc.config.AdhocConfig;
import debug.BaseApication;
import aliylog.logutils.AppUtils;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by huangweishui on 2018/3/23.
 */

public class MyApplication extends BaseApication {
    public static Context mContext;
    private static RefWatcher watcher;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        AppUtils.syncIsDebug(this);
        AdhocConfig adhocConfig = new AdhocConfig.Builder()
//设置App上下文(必要参数)
                .context(this)
//设置Appkey(必要参数)
                .appKey("123")
//设置clientId,将替换为clientId
                .clientId("xxxx")
//添加定向试验条件（自定义用户标签）
                .addCustom("sex", "male")
//调用后,优化指标只有在wifi网络下才会上报数据(可能会造成官网数据延时显示)
                .reportWifi()
                .enableDebugAssist(true)
                .build();

        AdhocTracker.init(adhocConfig);
        String sex=AdhocTracker.getFlag("sex","nan");
        //初始化LeakCanary
        initLeakCanary();

    }
    public void initLeakCanary(){
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        watcher=LeakCanary.install(this);
    }
    public static RefWatcher getRefWatcher() { return watcher; }
}
