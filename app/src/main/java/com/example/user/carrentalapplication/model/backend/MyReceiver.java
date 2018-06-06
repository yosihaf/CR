package com.example.user.carrentalapplication.model.backend;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.controller.MainActivity;


import static android.content.Context.NOTIFICATION_SERVICE;

public class MyReceiver extends  BroadcastReceiver {

    private MainActivity a=new MainActivity();
    public static final String s =
            "com.example.user.carrentalapplication.A_CUSTOM_INTENT";
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        //Bundle b = intent.getExtras();
        if (intent.getAction().matches(s))
            //a.Notify("a","b");
            Toast.makeText(context, "Order Closed" , Toast.LENGTH_LONG).show();

    }

}
