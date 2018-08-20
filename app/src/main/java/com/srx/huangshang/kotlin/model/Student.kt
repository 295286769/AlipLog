package com.srx.huangshang.kotlin.model

import com.srx.huangshang.kotlin.inteface.Person

/**
 * Created by huangweishui on 2018/5/4.
 */
class Student : Person() {

    override fun description():String {
        description = "学生"
        return description
    }
}