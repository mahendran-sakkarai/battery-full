package com.mahendran_sakkarai.battery_full;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTrackingService();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goToSettings();
                }
            });
        }
    }

    private void startTrackingService() {
        if (Utils.isConnected(this)) {
            startService(new Intent(this, BatteryTrackingService.class));
        }
    }

    private void goToSettings() {
        Intent settingIntent = new Intent(this, AlarmActivity.class);
        startActivity(settingIntent);
    }
}
