package com.aliyun.sls.kotlin.controll

import com.aliyun.sls.kotlin.inteface.Person

/**
 * Created by huangweishui on 2018/5/4.
 */
open class DescriptionBase :Person{
    var person:Person? = null

    constructor(person:Person){
        this.person=person
    }
    override fun description(): String? {
       return person?.description()
    }

}