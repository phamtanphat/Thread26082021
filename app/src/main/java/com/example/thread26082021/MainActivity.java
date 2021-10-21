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

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
               handlePrint("A");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                handlePrint("B");
            }
        });

        threadA.start();
        threadB.start();

        new CountDownTimer(10, 10) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Log.d("BBB","Thread A " + threadA.getState().toString());
                Log.d("BBB","Thread B " + threadB.getState().toString());
            }
        }.start();
    }

    private synchronized void handlePrint(String name){
        for (int i = 0; i < 1000; i++) {
            Log.d("BBB",name + " " + i);
        }
    }
}