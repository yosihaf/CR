package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.carrentalapplication.R;

public class ModelActivity extends BaseActivity implements View.OnClickListener {

    private Button addModel;
    private Button getModel;

    private void findViews() {
        addModel = (Button) findViewById(R.id.addModel_btn);
        getModel = (Button) findViewById(R.id.getModel_btn);

        addModel.setOnClickListener( this );
        getModel.setOnClickListener( this );

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
        if(v==getModel)
        {
            GetModel();
        }

    }

    private void GetModel() {
        Intent intent = new Intent(this,GetModelActivity.class);
        startActivity(intent);
    }

    private void AddModel() {
        Intent intent = new Intent(this,AddModelActivity.class);
        startActivity(intent);
    }
}
