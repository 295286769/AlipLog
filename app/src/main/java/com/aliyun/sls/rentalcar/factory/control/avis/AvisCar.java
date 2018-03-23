package com.aliyun.sls.rentalcar.factory.control.avis;

import android.util.Log;

import com.aliyun.sls.android.sdk.logutils.Logger;
import com.aliyun.sls.rentalcar.factory.carinterface.CarGeneral;

/**
 * Created by huangweishui on 2018/3/20.
 */

public abstract class AvisCar implements CarGeneral {
    public void setTabang(String tabang){
    }
    public void action(){

    };
    @Override
    public void name(String name) {
        Logger.i("TTT","=:"+name);
    }

    @Override
    public void money(String money) {
        Logger.i("TTT","=:"+money);
    }

    public <T extends CarGeneral>T  getCar(Class aClass){
        T general=null;
        if(aClass!=null){

            try {
                general= (T) aClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return general;
    }
}
