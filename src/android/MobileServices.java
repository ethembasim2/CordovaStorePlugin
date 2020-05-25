package com.huawei.cordovastoreplugin;


import android.content.Context;

import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.api.HuaweiApiAvailability;

public class MobileServices {

    public boolean isGMSAvailable(Context context) {

        if (null != context) {
            int result = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            if(com.google.android.gms.common.ConnectionResult.SUCCESS == result) {
                return true;
            }
        }
        return false;
    }

    public boolean isHMSAvailable(Context context) {

        if (null != context) {
            int result = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
            if(com.huawei.hms.api.ConnectionResult.SUCCESS == result) {
                return true;
            }
        }
        return false;
    }
}
