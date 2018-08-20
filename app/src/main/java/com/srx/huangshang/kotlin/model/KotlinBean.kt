package com.srx.huangshang.kotlin.model

import com.example.common.utils.Logger

/**
 * Created by huangweishui on 2018/4/16.
 */
class KotlinBean : BaseBean, BaseTwoBean {
    constructor()
    constructor(name: String?, age: Int?) : super(name, age) {
    }

    open fun getMyName(): String? = name
    inner class KotlinInner {
        fun getName(): String? = name
        fun getAge(kotlinInteface: KotlinInteface) {
            kotlinInteface.getAge()
        }
    }

    companion object {
        val head: String = ""
    }

    interface KotlinInteface {
        fun getAge()
    }

    override fun getName() {
        super<BaseBean>.getName()
        super<BaseTwoBean>.getName()
    }

    fun KotlinBean.getMy() {
        Logger.i("TTT", "getMy")
    }

    fun main(arg: Array<String>) {
        var user: KotlinBean = KotlinBean()
        user.getMy()
        var isTrue = when (user.name) {
            "huang", is String -> {

            }
            is String -> {

            }
            else -> {

            }
        }
        arg.forEach {
            Logger.i("TTT", "forEach" + it)
            if (it.equals("name")) return@forEach
        }
        Logger.i("TTT", "when" + isTrue)
        for (item in arg.iterator()) {
            Logger.i("TTT", "Array" + item)
        }
        avis@ for (i in arg.indices) {
            Logger.i("TTT", "Array" + arg[i])
            break@avis
        }
        var testDataBean = TestDataBean(name = "黄尚", age = 10)
        Logger.i("TTT", "testDataBean" + testDataBean.age)
        val testDataBeanCopy = testDataBean.copy(age = 30)
        Logger.i("TTT", "testDataBean" + testDataBeanCopy.age)
        val map = HashMap<String, String>()
        map.put("huang", "女")
        map.put("y", "" + 3)
        getSex(map)
        var outBean=OutBean<String>("a")
        var outBeanB=OutBean<String>("3")
        outBeanB=outBean
        Logger.i("TTT", "outBean" + outBean.getName())
        Logger.i("TTT", "outBeanB" + outBeanB.getName())
    }

    fun <T : Map<String, String>> getSex(value: T) {
        value.entries.forEach {
            Logger.i("TTT", "getSex" + it.key)
            Logger.i("TTT", "getSex" + it.value)
        }

    }

    class OutBean<out A>(val a: A) {
        fun getName(): A {
            return a
        }
    }
    enum class MyEnum{
        NAME,AGE
    }
}