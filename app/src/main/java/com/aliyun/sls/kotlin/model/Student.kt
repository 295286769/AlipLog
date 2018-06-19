package com.aliyun.sls.kotlin.model

import com.aliyun.sls.android.sdk.logutils.Logger
import com.aliyun.sls.kotlin.inteface.Person

/**
 * Created by huangweishui on 2018/5/4.
 */
class Student : Person() {

    override fun description():String {
        description = "学生"
        return description
    }
}