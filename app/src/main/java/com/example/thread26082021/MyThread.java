package com.example.thread26082021;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class MyThread extends Thread{
    public Handler handler;

    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB",Thread.currentThread().getState().name());
                handler.getLooper().quit();

            }
        });
        Looper.loop();
        Log.d("BBB","Finish");
        super.run();
    }
}
