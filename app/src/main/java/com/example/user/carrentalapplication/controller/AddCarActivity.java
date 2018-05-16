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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.backend.DB_manager;
import com.example.user.carrentalapplication.model.datasource.List_DBManager;
import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Gearbox;

import java.util.ArrayList;
import java.util.List;

public class AddCarActivity extends BaseActivity implements View.OnClickListener {

    private EditText kilometers,carNum ;
    private TextView  model,branch;
    private Button addCar;
    private Spinner modelNum,brunchNum;
    int indexModel=0;
    int indexBranch=0;

    private void findViews() {
        model= (TextView) findViewById(R.id.modelView);
        branch= (TextView) findViewById(R.id.BranchView);
        addCar = (Button) findViewById(R.id.OK_addCar_btn);
        brunchNum=(Spinner) findViewById(R.id.spinnerBrunch);
        brunchNum.setAdapter(new ArrayAdapter<Long>(this, android.R.layout.simple_spinner_item, brunchNum()));
        modelNum=(Spinner) findViewById(R.id.spinerModelNum);
        modelNum.setAdapter(new ArrayAdapter<Long>(this, android.R.layout.simple_spinner_item, codeModel()));

        kilometers=(EditText) findViewById(R.id.editKilometers);
        carNum=(EditText) findViewById(R.id.editCarNum);

        addCar.setOnClickListener(this);



    }

   private List<Long> brunchNum() {
        List<Long> lst = new ArrayList<Long>() ;
        String s;
        for (Branch item:DBManagerFactory.getManager().getAllBrunches())
        {
          s= item.getAdress();
            lst.add((long) item.getBranchNumber());
        }
        return lst;
    }

    private List<Long> codeModel()
    {
        List<Long> lst = new ArrayList<Long>() ;
        String s;

        for (CarModel item:DBManagerFactory.getManager().getAllModels())
        {
            s=item.getModel();
            lst.add(item.getCode());
        }
        return lst;
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
        Integer brunch = 0;
        Integer model=0;

        brunch= Integer.parseInt(brunchNum.getSelectedItem().toString());


        model = Integer.parseInt(modelNum.getSelectedItem().toString());
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

