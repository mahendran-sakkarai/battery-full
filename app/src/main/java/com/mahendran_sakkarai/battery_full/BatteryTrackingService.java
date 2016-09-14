package com.mahendran_sakkarai.battery_full;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by nantha on 13/9/16.
 */
public class BatteryTrackingService extends Service {
    private BatterTrackingReceiver batterTrackingReceiver = new BatterTrackingReceiver();

    @Override
    public void onCreate() {
        registerReceiver(batterTrackingReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    public void onDestroy(){
        unregisterReceiver(batterTrackingReceiver);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}
