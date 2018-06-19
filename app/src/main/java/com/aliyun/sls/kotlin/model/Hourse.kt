package com.aliyun.sls.kotlin.model

import com.aliyun.sls.kotlin.inteface.HouseInteface

/**
 * Created by huangweishui on 2018/4/28.
 */
class Hourse :HouseInteface{
    var hourName:String=""
    var hourPrice:String=""
    constructor(hourName:String,hourPrice:String){
        this.hourName=hourName
        this.hourPrice=hourPrice
    }
    override fun getHouseInfo() {
    }

    override fun getContract() {
    }

    override fun getPrice() {
    }
}