package com.srx.huangshang.kotlin.controll

import android.view.View
import com.example.common.utils.ToastUtil

/**
 * Created by huangweishui on 2018/5/31.
 */
class MyHandler {
    fun onClick(view: View){
        ToastUtil.show(view.getContext(),"成功")
    }
}