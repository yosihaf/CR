package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.carrentalapplication.R;

public class CarActivity extends BaseActivity implements View.OnClickListener {

    private Button addCar;
    private Button getCars;

    private void findViews() {
        addCar = (Button) findViewById(R.id.addCar_btn);
        getCars = (Button) findViewById(R.id.getCars_btn);

        addCar.setOnClickListener( this );
        getCars.setOnClickListener( this );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if(v==addCar)
        {
            AddCar();
        }
        if(v==getCars)
        {
            GetCars();
        }
    }

    public void AddCar()
    {
        Intent intent = new Intent(this,AddCarActivity.class);
        startActivity(intent);
    }
    public void GetCars()
    {
        Intent intent = new Intent(this,GetCarActivity.class);
        startActivity(intent);

    }
}
