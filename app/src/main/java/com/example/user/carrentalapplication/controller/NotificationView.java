package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.carrentalapplication.R;

public class NotificationView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_view);

        TextView text1 = (TextView) findViewById(R.id.text1);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            text1.setText(extras.getString("text").toString());
        }
    }
}