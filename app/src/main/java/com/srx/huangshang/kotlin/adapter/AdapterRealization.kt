package com.srx.huangshang.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.srx.huangshang.R
import com.srx.huangshang.kotlin.inteface.Meth

/**
 * Created by huangweishui on 2018/4/23.
 */
  open class AdapterRealization<T> : Meth<T>{

    open var mKotlinBeans:List<T>?=null
    open var mContent: Context? = null
     open var mViews= mutableListOf<View>()
     open var mViewItems= mutableListOf<HashMap<Int, View>>()
    public constructor(context:Context){
        mContent=context
        if(mViews!=null){
            mViews.clear()
        }else{
            mViews= mutableListOf();
        }
        if(mViewItems!=null){
            mViewItems.clear()
        }else{
            mViewItems=  mutableListOf()

        }
    }

    override fun initAdapter(data: List<T>) {
        mKotlinBeans=data
        if (data!=null&&data!!.size>0) {
            if (mViews!=null){
                mViews.clear()
                if(mViewItems!=null){
                    mViewItems.clear()
                }

                for (i in data!!.indices){
                    var viewMap:HashMap<Int, View>?= HashMap()
                    val view: View = LayoutInflater.from(mContent).inflate(R.layout.abc_action_bar_title_item,null)
                    val textName: TextView by lazy { view.findViewById(R.id.action_bar_title) as TextView }
                    if (viewMap != null) {
                        viewMap.put(R.id.action_bar_title,textName)
                        if(mViewItems!=null){
                            mViewItems.add(viewMap)
                        }
                    }
                    mViews.add(view)


                }
            }else{

            }
        }else{
            emtyView()
        }
    }

    override fun getViews():List<View> =mViews

    override fun emtyView() :List<View>{
        if(mContent!=null){
            var emtyView= LayoutInflater.from(mContent).inflate(R.layout.acitity_emty_view,null)
            if(mViews!=null){
                mViews.clear()
                mViews.add(emtyView)
            }
        }
        return mViews
    }

    override fun errorView() :List<View> {
        var errorView:View?
        if(mContent!=null){
             errorView= LayoutInflater.from(mContent).inflate(R.layout.activity_error_view,null)
            if(mViews!=null){
                mViews.clear()
                mViews.add(errorView)
            }
        }
        return mViews
    }
    override fun emtyView(view: View): List<View> {
        if(mContent!=null){

            if(mViews!=null){
                mViews.clear()
                mViews.add(view)
            }
        }
        return mViews
    }

    override fun errorView(view: View): List<View> {
        if(mContent!=null){

            if(mViews!=null){
                mViews.clear()
                mViews.add(view)
            }
        }
        return mViews
    }


}