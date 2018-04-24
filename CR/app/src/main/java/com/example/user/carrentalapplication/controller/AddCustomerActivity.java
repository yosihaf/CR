package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.Customer;

public class AddCustomerActivity extends Activity implements View.OnClickListener{

    private EditText lastName,firstName,id,phoneNumber,email,creditCard;
    private Button addCostumer;

    private void findViews() {
        addCostumer = (Button) findViewById(R.id.OK_addCostumer_btn);
        lastName=(EditText) findViewById(R.id.editLastName);
        firstName=(EditText) findViewById(R.id.editFirstName);
        id=(EditText) findViewById(R.id.editId);
        phoneNumber=(EditText) findViewById(R.id.editPhoneNumber);
        email=(EditText) findViewById(R.id.editEmail);
        creditCard=(EditText) findViewById(R.id.editCreditCard);

        addCostumer.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        findViews();
    }

    @Override
    public void onClick(View v) {
        if(v==addCostumer) {
            AddCostumer();
            Intent intent = new Intent(this, Customer.class);
            startActivity(intent);
        }


    }

    private Customer NewCustomer()
    {



        String last_name = lastName.getText().toString();
        String first_name = lastName.getText().toString();
        long _id = Long.parseLong(id.getText().toString());
        long phone_number = Long.parseLong(phoneNumber.getText().toString());
        String _email = email.getText().toString();
        long _creditCard = Long.parseLong(creditCard.getText().toString());

        return new Customer(last_name,first_name,_id,phone_number,_email,_creditCard);

    }
    private void AddCostumer() {
        try {

            new AsyncTask<Void,Void,Long>(){

                @Override
                protected void onPostExecute(Long aLong) {
                    super.onPostExecute(aLong);
                    if(aLong>0)
                        Toast.makeText( getBaseContext(), "Costumer "+aLong+" Added OK", Toast.LENGTH_SHORT ).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    return DBManagerFactory.getManager().addCustomer(NewCustomer());
                }
            }.execute();


        }
        catch (Exception e){

        }

    }

}
