package com.example.livingroom.autoservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    Timer timer = new Timer();
    // pass current context to timerTask
    TimerTask toastTask = new MyTimerTask(MyService.this);
    // when the service is created, start the scheduled timerTask
   @Override
    public void onCreate() {
       super.onCreate();
       // if battery is too low then stop it
       IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
       Intent batteryStatus = getApplicationContext().registerReceiver(null, ifilter);
       int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
       if (status < 5){
           this.stopSelf();
       }
       else {
           // prompt to let me know my service started, purely for debugging, can be removed
           Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
           timer.scheduleAtFixedRate(toastTask, 0, 10000);
       }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
        timer.cancel();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
