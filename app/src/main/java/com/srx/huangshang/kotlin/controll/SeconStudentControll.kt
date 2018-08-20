package com.srx.huangshang.kotlin.controll

import com.srx.huangshang.kotlin.inteface.Person

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