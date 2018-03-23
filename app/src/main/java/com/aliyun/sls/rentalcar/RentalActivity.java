package com.aliyun.sls.rentalcar;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import com.aliyun.sls.BuildConfig;
import com.aliyun.sls.R;
import com.aliyun.sls.android.sdk.logutils.Logger;
import com.aliyun.sls.rentalcar.factory.CompanyAbtrable.CompanyAbstract;
import com.aliyun.sls.rentalcar.factory.carinterface.CompanyGeneral;
import com.aliyun.sls.rentalcar.factory.control.avis.AotoCar;
import com.aliyun.sls.rentalcar.factory.control.avis.AvisCompanyControl;
import com.aliyun.sls.rentalcar.factory.control.avis.Passat;
import com.aliyun.sls.rentalcar.factory.control.didi.DDCompany;
import com.aliyun.sls.rentalcar.factory.control.didi.Porsche;

/**
 * Created by huangweishui on 2018/3/20.
 */

public class RentalActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.alert_dark_frame, options);
        AvisCompanyControl general = CompanyAbstract.getCompanyIntence(AvisCompanyControl.class);
        general.name();
        AotoCar aotoCar = general.getCarIntence(AotoCar.class);
        aotoCar.name("aoto");
        aotoCar.money("100万");
        aotoCar.setTabang("踏板");

        Passat passat = general.getCarIntence(Passat.class);
        passat.name("passat");
        passat.money("10万");

        DDCompany ddCompany = CompanyAbstract.getCompanyIntence(DDCompany.class);
        ddCompany.name();
        AotoCar aotoCar1 = ddCompany.getCarIntence(AotoCar.class);
        aotoCar1.name("aoto");
        aotoCar1.money("30万");
        aotoCar1.action();
        Porsche porsche = ddCompany.getCarIntence(Porsche.class);
        porsche.name("porsche");
        porsche.money("300万");
        String host=BuildConfig.SERVER_HOST;
        String appName=getResources().getString(R.string.avis);
        if (Logger.sDebug) {
            Toast.makeText(this, appName, Toast.LENGTH_SHORT).show();
        }
//        BuildConfig.SERVER_HOST;

    }

}
