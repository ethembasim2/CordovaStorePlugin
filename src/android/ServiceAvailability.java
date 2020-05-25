package com.huawei.cordovastoreplugin;

import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class ServiceAvailability extends CordovaPlugin {

    private final String GMS = "GMS";
    private final String HMS = "HMS";
    private final String NO_SERVICE = "NONE";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "checkAvailableService":
                String message = args.getString(0);
                this.checkAvailableService(callbackContext);
                return true;
            default :
                return false;
        }
    }

    public void checkAvailableService(CallbackContext callbackContext) {

        Context context = this.cordova.getActivity().getApplicationContext();

        MobileServices ms = new MobileServices();

        if(ms.isGMSAvailable(context)){
            callbackContext.success(GMS);
        }
        else if(ms.isHMSAvailable(context)){
            callbackContext.success(HMS);
        }
        else {
            callbackContext.error(NO_SERVICE);
        }
    }
}
