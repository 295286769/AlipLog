package com.aliyun.sls.rentalcar.factory.control.didi;

import android.util.Log;

import com.aliyun.sls.android.sdk.logutils.Logger;
import com.aliyun.sls.rentalcar.factory.CompanyAbtrable.CompanyAbstract;
import com.aliyun.sls.rentalcar.factory.carinterface.CarGeneral;
import com.aliyun.sls.rentalcar.factory.carinterface.CompanyGeneral;

/**
 * Created by huangweishui on 2018/3/22.
 */

public class DDCompany extends CompanyAbstract {
    @Override
    public void name() {
        Logger.i("TTT","=:"+"滴滴出租车");
    }


}
