package com.aliyun.sls.kotlin.activity

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast

import com.aliyun.sls.R

  open class KotlinActivity : android.support.v7.app.AppCompatActivity() {
   lateinit var mContext: android.content.Context
    var age:Int=-1


    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.aliyun.sls.R.layout.activity_first_kotlin)
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
