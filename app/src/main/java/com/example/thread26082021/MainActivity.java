package com.example.thread26082021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a, b, c;
    MyFlag myFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = b = c = 0;
        myFlag = new MyFlag(1);
        // 1 - Thread A thực thi logic
        // 2 - Thread B thực thi logic
        // 3 - Thread C thực thi logic

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag) {
                    for (int i = 1; i <= 50; ) {
                        if (myFlag.index == 1) {
                            a = i;
                            Log.d("BBB", "A : " + a);
                            myFlag.index = 2;
                            myFlag.notifyAll();
                            i++;
                        } else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag) {
                    for (int i = 1; i <= 50; ) {
                        if (myFlag.index == 2) {
                            b = i;
                            Log.d("BBB", "B : " + b);
                            myFlag.index = 3;
                            myFlag.notifyAll();
                            i++;
                        } else {
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myFlag) {
                    for (int i = 1; i <= 50; ) {
                        if (myFlag.index == 3) {
                            c = a + b;
                            Log.d("BBB", "C : " + c);
                            myFlag.index = 1;
                            myFlag.notifyAll();
                            i++;
                        }else{
                            try {
                                myFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();




    }

}