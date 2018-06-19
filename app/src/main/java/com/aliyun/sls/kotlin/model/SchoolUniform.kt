package com.aliyun.sls.kotlin.model

import com.aliyun.sls.android.sdk.logutils.Logger
import com.aliyun.sls.kotlin.controll.DescriptionBase
import com.aliyun.sls.kotlin.inteface.Person

/**
 * Created by huangweishui on 2018/5/4.
 */
class SchoolUniform:DescriptionBase{
    constructor(person:Person):super(person)
    override fun description() :String?{
      return super.description()+"校服"
    }

}