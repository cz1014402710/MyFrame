package com.chenz.myframe.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/10/30
 */
public class AndroidUtils {

    public static String getIMEI(Context c) {

        TelephonyManager mTelephonyMgr = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        final String imei = mTelephonyMgr.getDeviceId();
        return imei;
    }

    public static String getIMSI(Context c) {

        TelephonyManager mTelephonyMgr = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        final String imsi = mTelephonyMgr.getSubscriberId();
        return imsi;
    }
}
