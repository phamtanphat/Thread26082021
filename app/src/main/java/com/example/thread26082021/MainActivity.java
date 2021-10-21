package com.example.thread26082021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Object objectA = new Object();
        Object objectB = new Object();

        // Thread phụ (Background thread)
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
               synchronized (objectA){
                   try {
                       Log.d("BBB","Thread 1 đang chạy object A");
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   synchronized (objectB){
                       Log.d("BBB","Thread 1 đang chạy object B");
                   }
               }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectB){
                    try {
                        Log.d("BBB","Thread 2 đang chạy object B");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objectA){
                        Log.d("BBB","Thread 2 đang chạy object A");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();

        new CountDownTimer(2000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Log.d("BBB",threadA.getState().toString() + " " + threadA.isAlive());
                Log.d("BBB",threadB.getState().toString()+ " " + threadB.isAlive());
            }
        }.start();
    }
}