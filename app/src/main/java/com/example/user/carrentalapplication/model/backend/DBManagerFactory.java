package com.example.user.carrentalapplication.model.backend;

/**
 * Created by User on 12/04/2018.
 */
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.user.carrentalapplication.model.datasource.List_DBManager;
import com.example.user.carrentalapplication.model.datasource.MySQL_DBManager;

public class DBManagerFactory  {
    static DB_manager manager = null;

    public static DB_manager getManager() {
        if (manager == null)
            manager = new MySQL_DBManager();
        return manager;
    }


}
