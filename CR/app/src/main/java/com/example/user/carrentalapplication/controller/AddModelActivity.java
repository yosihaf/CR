package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Gearbox;

public class AddModelActivity extends Activity implements View.OnClickListener{

    private EditText code,company,model,engineCapacity,seats;
    private  Spinner gear;
    private Button addModel;


    private void findViews() {
        addModel = (Button) findViewById(R.id.OK_addModel_btn);
        code=(EditText) findViewById(R.id.editCode);
        company=(EditText) findViewById(R.id.editCompany);
        model=(EditText) findViewById(R.id.editModel);
        engineCapacity=(EditText) findViewById(R.id.editeNgineCapacity);
        gear=(Spinner) findViewById(R.id.editGear);
        seats=(EditText) findViewById(R.id.editSeats);

        addModel.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
    }
    @Override
    public void onClick(View v) {
        if(v==addModel) {
            AddModel();
            Intent intent = new Intent(this, ModelActivity.class);
            startActivity(intent);
        }
    }
    private CarModel NewModel()
    {
        long _code = Long.parseLong(code.getText().toString());
        String _company = company.getText().toString();
        String _model=model.getText().toString();
        long _engineCapacity = Long.parseLong(engineCapacity.getText().toString());
       // Gearbox _gear = Gearbox(seats.getText().toString());
        Integer _seats=Integer.parseInt(seats.getText().toString());

        return new CarModel(_code,_company,_model,_engineCapacity,Gearbox.AUTOMATIC,_seats);

    }
    private void AddModel() {
        try {

            new AsyncTask<Void, Void, Long>() {

                @Override
                protected void onPostExecute(Long aLong) {
                    super.onPostExecute(aLong);
                    if (aLong > 0)
                        Toast.makeText(getBaseContext(), "Model " + aLong + " Added OK", Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    return DBManagerFactory.getManager().addCarModel(NewModel());
                }
            }.execute();


        } catch (Exception e) {

        }
    }
}
