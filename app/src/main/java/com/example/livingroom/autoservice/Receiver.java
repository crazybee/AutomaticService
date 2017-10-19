package com.example.livingroom.autoservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver{
    private String TAG = "ReveiverTag";
    public Receiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // when broadCastRecerver receive "android.intent.action.BOOT_COMPLETED" event
        // start the service to show toasts
        Log.v(TAG,"Message received");
        Intent myIntent = new Intent(context, MyService.class);
        String action=intent.getAction();
        // only start the service when battery is not low
        if(!action.equalsIgnoreCase(Intent.ACTION_BATTERY_LOW) || action.equalsIgnoreCase(Intent.ACTION_BATTERY_OKAY)){
            context.startService(myIntent);
        }
    }
}
