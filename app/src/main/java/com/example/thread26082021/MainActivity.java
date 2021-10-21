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

        // Thread phụ (Background thread)
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB",Thread.currentThread().getName());
                for (int i = 0; i < 200; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(MainActivity.this, "sadasd", Toast.LENGTH_SHORT).show();
            }
        });
        thread.start();
    }
}