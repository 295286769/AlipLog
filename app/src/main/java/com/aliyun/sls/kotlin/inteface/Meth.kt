package com.aliyun.sls.kotlin.inteface

import android.view.View

/**
 * Created by huangweishui on 2018/4/23.
 */
open interface Meth<T> {
     fun initAdapter(data:List<T>)
     fun getViews():List<View>
     fun emtyView():List<View>
     fun errorView():List<View>
     fun emtyView(view:View):List<View>
     fun errorView(view:View):List<View>
}