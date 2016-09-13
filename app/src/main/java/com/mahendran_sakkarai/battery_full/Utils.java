package com.mahendran_sakkarai.battery_full;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by nantha on 13/9/16.
 */
public class Utils {
    public static boolean isServiceRunning(Context context, String serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
