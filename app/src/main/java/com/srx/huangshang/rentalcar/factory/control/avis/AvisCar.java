package com.srx.huangshang.rentalcar.factory.control.avis;

import com.srx.huangshang.rentalcar.factory.carinterface.CarGeneral;

import aliylog.logutils.Logger;

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
