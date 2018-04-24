package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.carrentalapplication.R;

public class CusomerActivity extends Activity  implements View.OnClickListener {

    private Button addCusomer;
    private Button isExist;


    private void findViews() {
        addCusomer = (Button) findViewById(R.id.addCusomer_btn);
        isExist = (Button) findViewById(R.id.isExistCusomer);

        addCusomer.setOnClickListener( this );
        isExist.setOnClickListener( this );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusomer);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if(v==addCusomer)
        {
            AddCusomer();
        }
        if(v==isExist)
        {
            IsExist();
        }
    }

    private void IsExist() {

    }

    private void AddCusomer() {
        Intent intent = new Intent(this,AddCustomerActivity.class);
        startActivity(intent);
    }
}
