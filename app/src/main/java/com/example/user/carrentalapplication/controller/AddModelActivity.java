package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Gearbox;

public class AddModelActivity extends BaseActivity implements View.OnClickListener{

    private EditText code,company,model,engineCapacity,seats;
    private Spinner gear;
    private Button addModel;


    private void findViews() {
        addModel = (Button) findViewById(R.id.OK_addModel_btn);
        code=(EditText) findViewById(R.id.editCode);
        company=(EditText) findViewById(R.id.editCompany);
        model=(EditText) findViewById(R.id.editModel);
        engineCapacity=(EditText) findViewById(R.id.editeNgineCapacity);
        gear=(Spinner) findViewById(R.id.editGear);
        gear.setAdapter(new ArrayAdapter<Gearbox>(this, android.R.layout.simple_spinner_item, Gearbox.values()));

        seats=(EditText) findViewById(R.id.editSeats);

        addModel.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
        findViews();
    }
    @Override
    public void onClick(View v) {
        if(v==addModel)
            if (TextUtils.isEmpty(code.getText().toString())) {
                code.setError("Field must be full");
                code.setHintTextColor(Color.RED);
            } else  if (TextUtils.isEmpty(company.getText().toString())) {
                company.setError("Field must be full");
                company.setHintTextColor(Color.RED);
            } else if (TextUtils.isEmpty(model.getText().toString())) {
                model.setError("Field must be full");
                model.setHintTextColor(Color.RED);
            } else if (TextUtils.isEmpty(engineCapacity.getText().toString())) {
                engineCapacity.setError("Field must be full");
                engineCapacity.setHintTextColor(Color.RED);
            } else   if (TextUtils.isEmpty(seats.getText().toString())) {
                seats.setError("Field must be full");
                seats.setHintTextColor(Color.RED);
            } else
            {
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
        String _gear = gear.getSelectedItem().toString();
        Gearbox g=Gearbox.AUTOMATIC;
        if(_gear=="Automatic")
            g=Gearbox.AUTOMATIC;
        if(_gear=="Manual")
            g=Gearbox.MANUAL;

        Integer _seats=Integer.parseInt(seats.getText().toString());

        return new CarModel(_code,_company,_model,_engineCapacity,g,_seats);

    }
    private void AddModel() {
        try {

            new AsyncTask<Void, Void, Long>() {

                @Override
                protected void onPostExecute(Long aLong) {
                    super.onPostExecute(aLong);
                    if (aLong > -1)
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