package com.aliyun.sls.kotlin.controll

import com.aliyun.sls.android.sdk.logutils.Logger
import com.aliyun.sls.kotlin.inteface.Person

/**
 * Created by huangweishui on 2018/5/4.
 */
class SeconStudentControll: DescriptionBase {
    constructor(person:Person) : super(person) {

    }

    override fun description() :String?{
       return super.description()+"二年级"
    }
}