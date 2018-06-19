package com.aliyun.sls.kotlin.adapter

import android.content.Context
import com.aliyun.sls.R
import com.aliyun.sls.kotlin.kotlinholder.MyKotlinHolder
import com.aliyun.sls.kotlin.model.DataBean
import com.chad.library.adapter.base.BaseQuickAdapter

/**
 * Created by huangweishui on 2018/5/31.
 */
class MyKotlinAdapter:BaseQuickAdapter<DataBean, MyKotlinHolder>{
    constructor(content:Context) : super(R.layout.kotlin_list_item) {
        mContext=content

    }
    override fun convert(helper: MyKotlinHolder?, item: DataBean?) {

    }
}