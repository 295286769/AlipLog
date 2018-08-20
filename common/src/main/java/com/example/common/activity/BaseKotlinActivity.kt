package com.example.common.activity

import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity

/**
 * Created by huangweishui on 2018/6/1.
 */
abstract class BaseKotlinActivity: AppCompatActivity() {
    lateinit var mContext: android.content.Context
    var age:Int=-1
//    lateinit var baseDataBinding:Any


    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(com.aliyun.sls.R.layout.activity_first_kotlin)
//        baseDataBinding= DataBindingUtil.setContentView(this,getBinding())
        mContext=this
        initData()
        initView()
        onPress()
    }
    abstract fun  getBinding():Int
    open fun initData(){}
    open fun initView(){}
    open fun onPress(){}
    open fun android.app.Activity.showToast(message:String){
        android.widget.Toast.makeText(this,message, android.widget.Toast.LENGTH_SHORT).show()
    }
}