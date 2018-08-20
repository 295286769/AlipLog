package com.srx.huangshang.rentalcar.factory.carinterface;

/**
 * Created by huangweishui on 2018/3/20.
 */

public interface CompanyGeneral {
    void name();
    public <T extends CarGeneral> T getCarIntence(Class<T> tClass);
//    public <T extends CarGeneral> T getCompanyIntence(Class<T> tClass);

}
