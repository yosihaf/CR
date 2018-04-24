package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.user.carrentalapplication.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.car_rental_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.home:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.carMenu:
                intent = new Intent(this, CarActivity.class);
                startActivity(intent);
                return true;
            case R.id.addCarMenu:
                intent = new Intent(this, AddCarActivity.class);
                startActivity(intent);
                return true;
            case R.id.getCarMenu:
                intent = new Intent(this, GetCarActivity.class);
                startActivity(intent);
                return true;
            case R.id.carModelMenu:
                intent = new Intent(this, ModelActivity.class);
                startActivity(intent);
                return true;
            case R.id.addCarModelMenu:
                intent = new Intent(this, AddModelActivity.class);
                startActivity(intent);
                return true;
            case R.id.getCarModelMenu:
                intent = new Intent(this, GetModelActivity.class);
                startActivity(intent);
                return true;
            case R.id.customerMenu:
                intent = new Intent(this, CusomerActivity.class);
                startActivity(intent);
                return true;
            case R.id.addCustomerMenu:
                intent = new Intent(this, AddCustomerActivity.class);
                startActivity(intent);
                return true;
            case R.id.getCustomerMenu:
                intent = new Intent(this, GetCustomerActivity.class);
                startActivity(intent);
                return true;
            case R.id.branchMenu:
                intent = new Intent(this, BranchActivity.class);
                startActivity(intent);
                return true;
            case R.id.getBranchMenu:
                intent = new Intent(this, GetBranchesActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
