package com.example.user.carrentalapplication.model.backend;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


    public static final String s =
            "com.example.user.carrentalapplication.A_CUSTOM_INTENT";
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle b = intent.getExtras();
        if (intent.getAction().matches("com.example.user.carrentalapplication.A_CUSTOM_INTENT"))
            Toast.makeText(context, "Order Closed"  , Toast.LENGTH_LONG).show();




    }
}
