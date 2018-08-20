package com.example.common.utils

import android.text.TextUtils

/**
 * Created by huangweishui on 2018/4/28.
 */
class KotlinTimeUtils {
    /**
     * 剩余支付时间
     * @param _ms
     * *
     * @return
     */
    companion object{
        fun ms2HMS(ms: Long): String {
            var _ms = ms
            if (_ms <= 0) {
                return ""
            }
            var hMStime = ""
            _ms /= 1000
            if (_ms <= 0) {
                return ""
            }
            val hour = _ms / 3600
            var hourStr = ""
            if (hour > 0) {
                hourStr = hour.toString()
                if (hour < 10) {
                    hourStr = "0" + hourStr
                }
            }
            var mint: Long = 0
            var mintStr = ""
            var sed: Long = 0
            //		if(_ms%3600>0){
            mint = _ms % 3600 / 60

            if (mint > 0) {
                sed = _ms % 60

                mintStr = mint.toString()
                if (mint < 10) {
                    mintStr = "0" + mintStr
                }
            } else {
                mintStr = "00"
            }
            //		}else {
            //			mintStr="00";
            //		}


            var sedStr = sed.toString()
            if (sed < 10) {
                sedStr = "0" + sedStr
            }
            if (!TextUtils.isEmpty(hourStr)) {
                hMStime = "$hourStr:$mintStr:$sedStr"
            } else {
                hMStime = mintStr + ":" + sedStr
            }

            return hMStime
        }
    }

}