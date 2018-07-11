package com.example.common.aplication;

import android.app.Application;
import android.support.compat.BuildConfig;
import android.text.TextUtils;
import android.view.View;

import java.util.Properties;

import static android.provider.Telephony.Mms.Part.CHARSET;
import static android.provider.UserDictionary.Words.APP_ID;

/**
 * Created by huangweishui on 2018/7/6.
 */

public class BaseAppplication extends Application {
    private String privateKey = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDGcRrBjrfeVzwgA3VKyX7EK8r34mpeRLuIVw" +
            "8Q2gAKpcua9hprphWphAQfmWgxUpXd/jCduWba3ndtTfczxbFy2HZ7ymMmamlm5PdGZeQLfsXtAsttI5LCKEwRkVMaJae9mHcfzn67cu2gPIi" +
            "/ql5BXLpj2FplqYCr8hrrVZzKfA/AA7/NJM0FpkgdRwrQPLD0pSZF1HYahZB4OLH566tiGqrYdjWyffZH1LMlsSj/8vGwR4LZplZCH8mIjW" +
            "/n8VT6aybKpRUAhgrO6Jis+OBzrzUs3nRQEUGEIkDonTBY+zMGFfMsTPa+wmXmYO27zjjJRN5hRSYgmqvlVB//INifAgMBAAECggEBAKSM1Wr7NWyhWbISLAi" +
            "/3OY+iifTD/DrfbYous12d+JcaOEugeoR5pSSa/jn9IYxvSQ/y4B+ZNPI9a8ln37Gx8Y7yMQNpvoL8yrnYkR16Qu" +
            "/K9DFKHpvrRpi3/ERWJ+t6dJFw0IUsPIu8uyURbDpTQ9WHRj+Jrd2PsRWFgxfCYy8rO0YA" +
            "+4yV4vJOfKEn5qnPqdVk2aahUIY1GAZdszTqjwYJLzUyE6Oui8oKN0OBKIeE8Ta1KH" +
            "+wzcMtniEHoMA1fLERqifqNQ0NQeLdY8YUiQY7mvAX3OjMXcUvo8vo2xm0gwow1twRzmO9FlVCI63Z9cj3r3mXdaPNoFsNuNeYUECgYEA7QTxKnO7Eerk2mIj1tGidiQ7" +
            "+BeQzk2XhN2LwJ9h/QBbnRrQB7SS6O9YqUS2YVSmYVNf+pwUa9GEy9IQBM8JGbqRCk9JNxkOxQNp6GIMF4IJ/fiDtHjSKCT1uo+80qVkF0oBsbOqaY4j9gsZ8S+qh72yM" +
            "+Ykje5Lz5559vHUjsMCgYEA1lVMKZ0kgzmngu41ZTc2R9wvxZ7XepfqNWS4N06BIYNjeR8/kxZX2QKMu7tC5xk3SAeqZhMLWk1BpktzLCDcqEuZeSp+MRio79DYDjGcK0h" +
            "/LcLQDOO1QgYrGpW1uyS2br4Z1eVhFCJh2RL4cLcZ+bXbmRl1jvpbw0m9vmcnaPUCgYEA4GXAad+96Z3I45Tst3Ir7MwrVpwBBcDiRfF2YXzEScLv+ZKsB8+HEy" +
            "+fckpSnV2GVDiacusYTmfD4TBU6CiXRhujO+6Ks7ZujEnKGC/ToOIF0cRZ9SA6X7V2TBXPwGLDm2T" +
            "+q54dJehj1Yr3Gah2PCN1trsaOqG0drFkaU7VXf8CgYEAnSWPIRfBdKFqC1qCNcLkfo2XTSroTE9j/l/pnUtm7F58KYtavopsQIVZEC" +
            "/9npljaeGM8yhVc5EfaED7ocg6YP6E+UzJl0" +
            "/AVYznTIjdOvL9pFyo1DqEZHNHWUeZJiyFwe6J3MVAh1WqLlF1bJcjaW4II1mCUyGG9El14Eubnp0CgYEAigg778gLnJ0fKKcG3Y4aKPV2sznC3SHWG3UqFJIdgw0LqDiDO3mbLsu+2FQnfA" +
            "/gZAwj8gVLrIlDCSzipixYgBK1hxj00y/mim0rfYBIeppneKT8VUorIrUoC1MNsRUdZz+llINoGZ2HBkNoO1yUic43fGLzch1gG07+we967M4=";

    @Override
    public void onCreate() {
        super.onCreate();

        Properties properties = new Properties();
//        properties.load(project.rootProject.file('local.properties').newDataInputStream())
    }

//    /**
//     * 支付宝支付业务
//     *
//     * @param v
//     */
//    public void payV2(View v) {
//
//        if (TextUtils.isEmpty("2018070560557459") || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty(privateKey))) {
//            new AlertDialog.Builder(this).setTitle("警告").setMessage("需要配置APPID | RSA_PRIVATE")
//                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialoginterface, int i) {
//                            //
//                            finish();
//                        }
//                    }).show();
//            return;
//        }
//
//        /**
//         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
//         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
//         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
//         *
//         * orderInfo的获取必须来自服务端；
//         */
//        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
//        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
//        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
//
//        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
//        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
//        final String orderInfo = orderParam + "&" + sign;
//
//        Runnable payRunnable = new Runnable() {
//
//            @Override
//            public void run() {
//                PayTask alipay = new PayTask(PayDemoActivity.this);
//                Map<String, String> result = alipay.payV2(orderInfo, true);
//                Log.i("msp", result.toString());
//
//                Message msg = new Message();
//                msg.what = SDK_PAY_FLAG;
//                msg.obj = result;
//                mHandler.sendMessage(msg);
//            }
//        };
//
//        Thread payThread = new Thread(payRunnable);
//        payThread.start();
//    }
}
