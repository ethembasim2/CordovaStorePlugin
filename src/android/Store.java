package com.huawei.cordovastoreplugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class Store extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "redirectToStore":
                String message = args.getString(0);
                this.redirectToStore(message);
                return true;
            default :
                return false;
        }
    }

    private void redirectToStore(String appId) throws android.content.ActivityNotFoundException {
        Context context = this.cordova.getActivity().getApplicationContext();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        MobileServices ms = new MobileServices();
        if(ms.isGMSAvailable(context)){
            intent.setData(Uri.parse("market://details?id=" + appId));
        }
        else if(ms.isHMSAvailable(context)){
            intent.setData(Uri.parse("appmarket://details?id=" + appId));
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
