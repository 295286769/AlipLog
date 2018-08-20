package com.srx.huangshang.kotlin.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by huangweishui on 2018/8/20.
 */

public class SexBean extends BaseObservable {
    private String title;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
//        notifyPropertyChanged(BR.title);
    }
}
