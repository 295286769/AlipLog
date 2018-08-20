package com.srx.huangshang.kotlin.adapter

import android.view.View

/**
 * Created by huangweishui on 2018/4/23.
 */
  abstract class BaseAdapter<T> {
     abstract fun initAdapter(data:List<T>)
     abstract fun getViews():List<View>
     abstract fun getEmtyView()
}