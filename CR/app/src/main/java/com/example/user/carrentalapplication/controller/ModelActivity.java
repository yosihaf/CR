package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.carrentalapplication.R;

import static com.example.user.carrentalapplication.R.string.addCar;
import static com.example.user.carrentalapplication.R.string.getCars;

public class ModelActivity extends Activity implements View.OnClickListener {


    private Button addModel;


    private void findViews() {
        addModel = (Button) findViewById(R.id.addModel_btn);
        addModel.setOnClickListener( this );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if(v==addModel)
        {
            AddModel();
        }

    }

    private void AddModel() {
        Intent intent = new Intent(this,AddModelActivity.class);
        startActivity(intent);
    }
}
