package com.example.livingroom.autoservice;

/**
 * Created by livingroom on 8/26/2016.
 * This is the Task class to show toast.The task is invoked from MyService every 10 seconds
 */
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
public class MyTimerTask extends java.util.TimerTask {

    private Context context;
    private Handler mHandler = new Handler();
    private String TAG = "TimerTask";

    public MyTimerTask(Context con) {
        this.context = con;
    }

    // this is the task to show the message
    @Override
    public void run() {
        new Thread(new Runnable() {

            public void run() {

                mHandler.post(new Runnable() {
                    public void run() {
                        // display the toast message, make it short
                        Log.v(TAG, "Inside timierTask now");
                        Toast.makeText(context, "Hello, My name is Liu Zhe", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }).start();

    }

}