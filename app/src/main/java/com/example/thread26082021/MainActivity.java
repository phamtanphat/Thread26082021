package com.example.thread26082021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        handler = new Handler(Looper.getMainLooper()){
//            @Override
//            public void handleMessage(@NonNull Message msg) {
//                switch (msg.what){
//                    case 1 :
//                        Log.d("BBB",msg.obj.toString());
//                        break;
//                    case 2 :
//                        Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//                super.handleMessage(msg);
//            }
//        };
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                for (int i = 1; i <= 100; i++) {
//                    Message message = new Message();
//                    message.what = 1;
//                    message.obj = i;
//                    handler.sendMessage(message);
//                }
//                Message message = new Message();
//                message.what = 2;
//                handler.sendMessage(message);
//            }
//        });
//        thread.start();

        MyThread thread = new MyThread();
        thread.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.d("BBB",thread.getState().name());
            }
        },2000);

    }

}