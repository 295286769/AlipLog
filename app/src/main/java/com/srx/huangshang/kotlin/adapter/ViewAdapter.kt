package com.srx.huangshang.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.srx.huangshang.R
import com.srx.huangshang.kotlin.model.KotlinBean

/**
 * Created by huangweishui on 2018/4/23.
 */
 open class ViewAdapter<T>:AdapterRealization<T>{





    constructor(content: Context):super(content) {

    }
    fun makeText(index:Int,drawableId:Int):Unit{
        if(mViewItems!=null){
            var map:HashMap<Int, View>?=mViewItems.get(index)
            if(map!=null){
                if(map.get(drawableId) is TextView){
                    var textView: TextView = map.get(drawableId) as TextView;
                    textView.visibility= View.VISIBLE
                    if(mKotlinBeans!=null&& mKotlinBeans!!.size>0){
                        var bean:KotlinBean?=mKotlinBeans?.get(index) as KotlinBean?:null
//                        var bean=mKotlinBeans?.get(index)?:null
                        if(bean!=null){
                            textView.text=bean.name
                        }
                    }
                }


            }

        }
    }
     fun emtyViewItem():View?{
        var emtyView:View?=null
        if(mContent!=null){
             emtyView= LayoutInflater.from(mContent).inflate(R.layout.acitity_emty_view,null)

        }
        return emtyView
    }



}