package com.srx.huangshang.utils;

import android.content.Context;
import android.content.Intent;

import com.srx.huangshang.rentalcar.activity.TrainActivity;

/**
 * Created by huangweishui on 2018/6/19.
 */

public class ActivityUtils {
    public static void startActivity(Context context,int type){
        Intent intent=new Intent(context, TrainActivity.class);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }
}
