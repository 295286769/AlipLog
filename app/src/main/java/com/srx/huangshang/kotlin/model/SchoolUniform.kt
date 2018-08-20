package com.srx.huangshang.kotlin.model

import com.srx.huangshang.kotlin.controll.DescriptionBase
import com.srx.huangshang.kotlin.inteface.Person

/**
 * Created by huangweishui on 2018/5/4.
 */
class SchoolUniform:DescriptionBase{
    constructor(person:Person):super(person)
    override fun description() :String?{
      return super.description()+"校服"
    }

}