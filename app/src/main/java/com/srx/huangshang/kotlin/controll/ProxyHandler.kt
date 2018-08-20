package com.srx.huangshang.kotlin.controll

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy



/**
 * Created by huangweishui on 2018/4/28.
 */
class ProxyHandler: InvocationHandler {
    var ob:Any?=null
    fun newProxyInstance(ob:Any?):Any{
       this.ob=ob
        return Proxy.newProxyInstance(ob?.javaClass?.classLoader,ob?.javaClass?.interfaces,this)
    }
    override fun invoke(p0: Any?, p1: Method?, p2: Array<out Any>?): Any? {
       var ret:Any? = p1?.invoke(ob, p2)
        return ret
    }
}