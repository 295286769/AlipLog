package com.srx.huangshang.kotlin.controll

import com.srx.huangshang.kotlin.inteface.Person

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