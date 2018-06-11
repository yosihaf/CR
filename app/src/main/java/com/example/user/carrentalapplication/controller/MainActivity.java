package com.example.user.carrentalapplication.controller;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.backend.Receiver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Button cars;
    private Button customers;
    private Button brunch;
    private Button model;
    Receiver receiver;
    public static final String mBroadcastStringAction = "com.example.user.carrentalapplication.A_CUSTOM_INTENT";
    private void findViews()
    {
        cars =(Button)findViewById( R.id.car_btn );
        customers =(Button)findViewById( R.id.customers_btn );
        brunch =(Button)findViewById( R.id.brunch_btn );
        model =(Button)findViewById( R.id.model_btn );

        cars.setOnClickListener( this );
        customers.setOnClickListener( this );
        brunch.setOnClickListener( this );
        model.setOnClickListener( this );

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        IntentFilter filter = new IntentFilter(Receiver.s);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new Receiver();
        registerReceiver(receiver, filter);
        try {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    List<String> lst = new ArrayList<String>() ;
                    DBManagerFactory.getManager();
                    return null;
                }
            }.execute();
        } catch (Exception e) {

        }
    }



    @Override
    public void onClick(View v) {
        if(v==cars)
        {
            Car();
        }
        else if(v==customers)
        {
            Customers();
        }
        else if(v==brunch)
        {
            Brunch();
        }
        else if(v==model)
        {
            Model();
        }
    }

    private void Car()
    {
        Intent intent = new Intent(this,CarActivity.class);
        startActivity(intent);
    }

    private void Customers()
    {
        Intent intent = new Intent(this,CusomerActivity.class);
        startActivity(intent);

    }
    private void Brunch()
    {
        Intent intent = new Intent(this,BranchActivity.class);
        startActivity(intent);
    }
    private void Model()
    {
        Intent intent = new Intent(this,ModelActivity.class);
        startActivity(intent);

    }

    private void home()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }








}
