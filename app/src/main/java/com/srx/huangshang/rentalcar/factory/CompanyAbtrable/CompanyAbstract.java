package com.srx.huangshang.rentalcar.factory.CompanyAbtrable;

import com.srx.huangshang.rentalcar.factory.carinterface.CarGeneral;
import com.srx.huangshang.rentalcar.factory.carinterface.CompanyGeneral;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by huangweishui on 2018/3/22.
 */

public abstract   class CompanyAbstract implements CompanyGeneral {
    @Override
    public void name() {

    }

    @Override
    public <T extends CarGeneral> T getCarIntence(Class<T> tClass) {
        if(tClass!=null){
            try {
                try {
            /*以下调用无参的、私有构造函数*/
                    Constructor c0=tClass.getDeclaredConstructor();
                    c0.setAccessible(true);
                    return (T) c0.newInstance();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static <T extends CompanyGeneral> T getCompanyIntence(Class<T> tClass) {
        if(tClass!=null){
            try {
                return tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
