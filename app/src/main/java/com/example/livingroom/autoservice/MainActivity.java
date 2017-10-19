package com.example.livingroom.autoservice;

import android.app.Activity;
import android.os.Bundle;
// this is just an empty activity to satisfy Android system
public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // call finish method to finish this fake activity, so user won't notice
        this.finish();
    }

}
