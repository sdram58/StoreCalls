package com.catata.storecalls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

class MyReceiver extends BroadcastReceiver {

    public static final String ACTION="ASD";

    Call mCall;

    public MyReceiver(Call call){
        this.mCall = call;
    }

    public  MyReceiver(){
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        /*if(intent.getAction().compareTo(ACTION)==0) {

            this.mCall.onIncomeCall(intent.getAction());
        }*/
        try {
            // TELEPHONY MANAGER class object to register one listener
            TelephonyManager tmgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            //Create Listener
            MyPhoneStateListener PhoneListener = new MyPhoneStateListener();

            // Register listener for LISTEN_CALL_STATE
            tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        } catch (Exception e) {
            Log.e("Phone Receive Error", " " + e);
        }

    }



    private class MyPhoneStateListener extends PhoneStateListener {

        public void onCallStateChanged(int state, String incomingNumber) {

            // Log.d("MyPhoneListener",state+"   incoming no:"+incomingNumber);


            // state = 1 means when phone is ringing
            if (state == 1) {

                String msg = " New Phone Call Event. Incomming Number : "+incomingNumber;
                int duration = Toast.LENGTH_LONG;


            }
        }
    }


}
