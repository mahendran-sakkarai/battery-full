package com.mahendran_sakkarai.battery_full;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent batteryTrackingIntent = new Intent(context, BatteryTrackingService.class);

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED) && !Utils.isServiceRunning(context, BatteryTrackingService.class.getName())) {
            context.startService(batteryTrackingIntent);
        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            context.stopService(batteryTrackingIntent);
        }
    }
}
