package com.aliyun.sls.kotlin.model

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.widget.Toast
import com.aliyun.sls.BR
import com.example.common.utils.ToastUtil

/**
 * Created by huangweishui on 2018/5/21.
 */
class DataBean : BaseObservable {
    var content: Context? = null
    var height: String = ""
    var name: String = ""
        @Bindable
        get() = field  // 将变量赋值后转换为大写
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    var age: Int = 0
        @Bindable
        get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor(content: Context, name: String, age: Int) : this(name, age) {
        this.content = content
    }

    fun DataBean.GetHeight() {

    }

    fun onClick(type: Int) {
        ToastUtil.show(content, "" + type)
    }
}