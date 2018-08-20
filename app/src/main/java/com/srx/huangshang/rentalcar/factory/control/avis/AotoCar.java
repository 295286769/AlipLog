package com.srx.huangshang.rentalcar.factory.control.avis;


import aliylog.logutils.Logger;

/**
 * Created by huangweishui on 2018/3/20.
 */

public class AotoCar extends AvisCar {
    private String tabang;
    private AotoCar(){

    }
    @Override
    public void setTabang(String tabang){
        Logger.i("TTT","=:"+tabang);
    }

    @Override
    public void action() {
        super.action();
        Logger.i("TTT","=:"+"action");
    }
}
