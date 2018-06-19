package com.aliyun.sls.kotlin.controll

import android.content.Context
import com.aliyun.sls.android.sdk.logutils.Logger

/**
 * Created by huangweishui on 2018/6/14.
 */
class StaticControll {
    private constructor(context: Context)

   public companion object {
         private var staticControll: StaticControll?=null;
        public fun getInstence(context: Context): StaticControll? {
            if (staticControll == null) {
                synchronized(StaticControll::class) {
                    if (staticControll == null) {
                        staticControll = StaticControll(context)
                    }
                }
            }
            return staticControll
        }
    }

    fun setAge() {
        Logger.i("TTT", "sfsafd")
    }
}