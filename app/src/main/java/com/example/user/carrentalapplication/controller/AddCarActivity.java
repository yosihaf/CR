package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.backend.DB_manager;
import com.example.user.carrentalapplication.model.datasource.List_DBManager;
import com.example.user.carrentalapplication.model.entities.Car;

public class AddCarActivity extends BaseActivity implements View.OnClickListener {

    private EditText brunchNum,modelNum,kilometers,carNum;
    private Button addCar;



    private void findViews() {
        addCar = (Button) findViewById(R.id.OK_addCar_btn);
        brunchNum=(EditText) findViewById(R.id.editBrunch);
        modelNum=(EditText) findViewById(R.id.editModelNum);
        kilometers=(EditText) findViewById(R.id.editKilometers);
        carNum=(EditText) findViewById(R.id.editCarNum);

        addCar.setOnClickListener(this);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if(v==addCar)
            if (TextUtils.isEmpty(brunchNum.getText().toString())) {
                brunchNum.setError("Field must be full");
                brunchNum.setHintTextColor(Color.RED);}
            else
            if (TextUtils.isEmpty(modelNum.getText().toString())) {
                modelNum.setError("Field must be full");
                modelNum.setHintTextColor(Color.RED);}
            else
            if (TextUtils.isEmpty(kilometers.getText().toString())) {
                kilometers.setError("Field must be full");
                kilometers.setHintTextColor(Color.RED);}
            else
            if (TextUtils.isEmpty(carNum.getText().toString())) {
                carNum.setError("Field must be full");
                carNum.setHintTextColor(Color.RED);}
            else {
                AddCar();
                Intent intent = new Intent(this, CarActivity.class);
                startActivity(intent);
            }

    }





    private Car NewCar()
    {
        Integer brunch = Integer.parseInt(brunchNum.getText().toString());
        Integer model = Integer.parseInt(modelNum.getText().toString());
        Integer km = Integer.parseInt(kilometers.getText().toString());
        Integer car = Integer.parseInt(carNum.getText().toString());
        return new Car(brunch,model,km,car);

    }
    private void AddCar() {


            try {

                new AsyncTask<Void, Void, Long>() {

                    @Override
                    protected void onPostExecute(Long aLong) {
                        super.onPostExecute(aLong);
                        if (aLong > 0)
                            Toast.makeText(getBaseContext(), "Car " + aLong + " Added OK", Toast.LENGTH_SHORT).show();
                         else
                            Toast.makeText(getBaseContext(), "Car is Exsist", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected Long doInBackground(Void... params) {
                        return DBManagerFactory.getManager().addCar(NewCar());
                    }
                }.execute();


            } catch (Exception e) {

            }

        }


    }

