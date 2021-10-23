package com.example.thread26082021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a , b ,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = b = c = 0;

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50 ; i++) {
                    a = i;
                    Log.d("BBB","A : " + a);
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50 ; i++) {
                    b = i;
                    Log.d("BBB","B : " + b);
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50 ; i++) {
                    c = a + b;
                    Log.d("BBB","C : " + c);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }

}