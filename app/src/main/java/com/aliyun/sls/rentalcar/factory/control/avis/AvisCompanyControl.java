package com.aliyun.sls.rentalcar.factory.control.avis;

import android.util.Log;

import com.aliyun.sls.rentalcar.factory.CompanyAbtrable.CompanyAbstract;
import com.aliyun.sls.rentalcar.factory.carinterface.CarGeneral;
import com.aliyun.sls.rentalcar.factory.carinterface.CompanyGeneral;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by huangweishui on 2018/3/20.
 */

public class AvisCompanyControl extends CompanyAbstract {
    @Override
    public void name() {
        Log.i("TTT","=:"+"安飞士出租车");
    }
}
