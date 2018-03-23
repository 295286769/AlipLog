package com.aliyun.sls.android.sdk.logutils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.aliyun.sls.android.sdk.model.Log;

/**
 * Created by huangweishui on 2018/3/23.
 */

public class AppUtils {
    private static Boolean isDebug = null;

    public static boolean isDebug() {
        return isDebug == null ? false : isDebug.booleanValue();
    }

    /**
     * Sync lib debug with app's debug value. Should be called in module Application
     *
     * @param context
     */
    public static void syncIsDebug(Context context) {
        android.util.Log.i("TTT","getApplicationInfo"+context.getApplicationInfo().toString());
        android.util.Log.i("TTT","FLAG_DEBUGGABLE"+ApplicationInfo.FLAG_DEBUGGABLE);
        if (isDebug == null) {
            isDebug = context.getApplicationInfo() != null &&
                    (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        }
    }
}
