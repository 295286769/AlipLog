package com.srx.huangshang.kotlin.model


/**
 * Created by huangweishui on 2018/4/23.
 */
open class BaseBean() {
     open var name: String? = ""
//        set(value) {
//            field = value
//            Logger.i("TTT", "name:+" + name)
//        }
//        get() = field
    open var age: Int? = 0
//        set(value) {
//            field = value
//            Logger.i("TTT", "age:+" + age)
//        }
//        get() = field

    constructor(name:String?, age:Int?):this() {
        this.name = name
        this.age = age
    }
    open fun getName(){

    }


}