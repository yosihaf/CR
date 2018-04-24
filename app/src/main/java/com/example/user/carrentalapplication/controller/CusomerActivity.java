package com.example.user.carrentalapplication.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.carrentalapplication.R;

public class CusomerActivity extends BaseActivity  implements View.OnClickListener {

    private Button addCusomer;
    private Button getCustumer;
    private Button isExist;


    private void findViews() {
        addCusomer = (Button) findViewById(R.id.addCusomer_btn);
        getCustumer=(Button)findViewById(R.id.getCusomer_btn);
        isExist = (Button) findViewById(R.id.isExistCusomer_bth);


        addCusomer.setOnClickListener( this );
        getCustumer.setOnClickListener( this );
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
        if(v== getCustumer){
            GetCustumer();
        }
        if(v==isExist)
        {
            IsExist();
        }
    }

    private void GetCustumer() {
        Intent intent = new Intent(this,GetCustomerActivity.class);
        startActivity(intent);
    }

    private void IsExist() {
        Intent intent = new Intent(this,IsExsitsCustomerActivity.class);
        startActivity(intent);
    }

    private void AddCusomer() {
        Intent intent = new Intent(this,AddCustomerActivity.class);
        startActivity(intent);

    }
}
