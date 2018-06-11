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
import com.example.user.carrentalapplication.controller.NotificationView;


import static android.content.Context.NOTIFICATION_SERVICE;

public class Receiver extends  BroadcastReceiver {


    public static final String s =
            "com.example.user.carrentalapplication.A_CUSTOM_INTENT";
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle b = intent.getExtras();
        if (intent.getAction().matches(s))
            Notify(context,"Close order",b.getString("OUT_MESSAGE",""));
    }

    public void Notify(Context context, String notificationTitle, String notificationMessage) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.btn_star)
                .setContentTitle(notificationTitle)
                .setContentText(notificationMessage);
                //.setStyle(new NotificationCompat.InboxStyle());
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(888, builder.build());


    }

}
