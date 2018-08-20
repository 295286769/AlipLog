package com.srx.huangshang.kotlin.model

/**
 * Created by huangweishui on 2018/5/25.
 */
class TestDataBean(var name:String,val age:Int) {
    fun copy(name: String = this.name, age: Int = this.age) = TestDataBean(name, age)
}