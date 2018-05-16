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
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;

public class AddBranch extends BaseActivity implements View.OnClickListener {

    private EditText id,address,space;
    private Button addBranch;

    private void findViews() {
        id= (EditText) findViewById(R.id.editBranchNum);
        address= (EditText) findViewById(R.id.editAddress);
        space = (EditText) findViewById(R.id.editSpace);
        addBranch = (Button) findViewById(R.id.OK_addBranchbtn);

        addBranch.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);
        findViews();
    }



    @Override
    public void onClick(View v) {
        if(v==addBranch)
            if (TextUtils.isEmpty(id.getText().toString())) {
                id.setError("Field must be full");
                id.setHintTextColor(Color.RED);}
            else
            if (TextUtils.isEmpty(address.getText().toString())) {
                address.setError("Field must be full");
                address.setHintTextColor(Color.RED);}
            else
                if (TextUtils.isEmpty(space.getText().toString())) {
                    space.setError("Field must be full");
                    space.setHintTextColor(Color.RED);
            }
            else {
                AddBranch();
                Intent intent = new Intent(this, BranchActivity.class);
                startActivity(intent);
            }
    }


    private Branch NewBranch()
    {

        Integer num = Integer.parseInt(id.getText().toString());
        String addre = (address.getText().toString());
        Integer spa = Integer.parseInt(space.getText().toString());
        return new Branch(addre,spa,num);
    }

    private void AddBranch() {


        try {

            new AsyncTask<Void, Void, Long>() {

                @Override
                protected void onPostExecute(Long aLong) {
                    super.onPostExecute(aLong);
                    if (aLong > 0)
                        Toast.makeText(getBaseContext(), "Branch " + aLong + " Added OK", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getBaseContext(), "Branch is Exsist", Toast.LENGTH_SHORT).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    return DBManagerFactory.getManager().addBranch(NewBranch());
                }
            }.execute();


        } catch (Exception e) {

        }

    }
}
