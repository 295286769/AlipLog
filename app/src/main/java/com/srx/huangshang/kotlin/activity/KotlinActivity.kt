package com.srx.huangshang.kotlin.activity

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


open class KotlinActivity : AppCompatActivity() {
   lateinit var mContext: Context
    var age:Int=-1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.srx.huangshang.R.layout.activity_first_kotlin)
        mContext=this
        initData()
        initView()
        onPress()
    }
   open fun initData(){}
    open fun initView(){}
    open fun onPress(){}
    open fun android.app.Activity.showToast(message:String){
        android.widget.Toast.makeText(this,message, android.widget.Toast.LENGTH_SHORT).show()
    }

}
