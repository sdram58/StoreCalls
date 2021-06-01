package com.catata.storecalls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.catata.storecalls.Call;

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.getName();
    private static final int WAITING_TIME = 5000;


    MyReceiver myReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myReceiver = new MyReceiver(new Call() {
            @Override
            public void onIncomeCall(String s) {
                Log.i(TAG,s);
            }
        });

        intentFilter = new IntentFilter(MyReceiver.ACTION);


        Intent i = new Intent(MyReceiver.ACTION);


        //Hacemos que no lo envíe de inmediato, esperamos 5 segundos para poder cambiar de aplicación y verlo
       /* Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendBroadcast(i);
            }
        },  WAITING_TIME);*/



    }


    @Override
    protected void onResume(){
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onDestroy(){
        registerReceiver(myReceiver, intentFilter);
        super.onDestroy();
    }
}