package com.aliyun.sls.kotlin.controll

/**
 * Created by huangweishui on 2018/4/13.
 */
 open class FirstControll constructor(){

     open var firstControll:FirstControll?=null
    fun getFirstControll():Unit{
        if(firstControll==null){
            firstControll=FirstControll()
        }
    }
    fun wenMeth(age:Int){
        when(age){
            1,3 -> {

            }
            2-> {

            }
            in 1..10 ->{

            }
            !in 20..25 -> {

            }
            else -> {

            }
        }
        fun hasPrefix(x: Any) = when(x) {
            is String -> x.startsWith("prefix")
            else -> false
        }
    }
}