package com.srx.huangshang.rentalcar.model;

import android.text.TextUtils;

/**
 * Created by huangweishui on 2018/6/19.
 */

public class TrainBean {
    private String name;

    public String getName() {
        return TextUtils.isEmpty(name)?"":name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
