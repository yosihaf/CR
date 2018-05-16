package com.example.user.carrentalapplication.controller;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.Customer;

import java.util.List;

public class IsExsitsCustomerActivity extends BaseActivity implements View.OnClickListener {

    private TextView lastName, firstName, idV, phoneNumber, email, creditCard, answer;
    private EditText id;
    private Button searchCostumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_exsits_customer);
        findViews();

    }

    private void findViews() {
        answer=(TextView) findViewById(R.id.answerView);
        lastName=(TextView) findViewById(R.id.lastNameView);
        firstName=(TextView) findViewById(R.id.firstNameView);
        idV=(TextView) findViewById(R.id.idView);
        phoneNumber=(TextView) findViewById(R.id.phoneNumberView);
        email=(TextView) findViewById(R.id.emailView);
        creditCard=(TextView) findViewById(R.id.creditCardView);
        id=(EditText) findViewById(R.id.editId);
        searchCostumer = (Button) findViewById(R.id.searchCustomer_btn);

        searchCostumer.setOnClickListener(this);
    }



    private String s()
    {
        return id.getText().toString();
    }

    private void SearchCostumer() {

       try {

            new AsyncTask<Void, Void, Customer>() {


                @Override
                protected void onPostExecute(Customer customer) {
                    super.onPostExecute(customer);

                    answer.setVisibility(View.INVISIBLE);

                    lastName.setVisibility(View.INVISIBLE);

                    lastName.setVisibility(View.INVISIBLE);

                    firstName.setVisibility(View.INVISIBLE);

                    idV.setVisibility(View.INVISIBLE);

                    phoneNumber.setVisibility(View.INVISIBLE);

                    email.setVisibility(View.INVISIBLE);

                    email.setVisibility(View.INVISIBLE);
                    if (customer != null) {
                        //answer.setVisibility(View.VISIBLE);
                       // answer.setText("is Exsist ");
                        lastName.setVisibility(View.VISIBLE);
                        lastName.setText("  Last Name: " + customer.getLastName());
                        lastName.setVisibility(View.VISIBLE);
                        firstName.setText("  First Name: " + customer.getFirstName());
                        firstName.setVisibility(View.VISIBLE);
                        idV.setText("  ID: " + ( customer.getId()).toString());
                        idV.setVisibility(View.VISIBLE);
                        phoneNumber.setText("  Phone Number:  " + ( customer.getPhoneNumber()).toString());
                        phoneNumber.setVisibility(View.VISIBLE);
                        email.setText("  Email Number: " + (customer.getEmail()).toString());
                        email.setVisibility(View.VISIBLE);
                        creditCard.setText("  Branch Number: " + ((Long) customer.getCreditCard()).toString());
                        email.setVisibility(View.VISIBLE);
                    } else {
                        answer.setVisibility(View.VISIBLE);
                        answer.setText("  is not Exsist ");

                    }
                }

                @Override
                protected Customer doInBackground(Void... params) {

                    return DBManagerFactory.getManager().ReturnCustumerById(s());
                }
            }.execute();


        } catch (Exception e) {

        }


    }


    @Override
    public void onClick(View v) {
        if (v == searchCostumer) {
            if (TextUtils.isEmpty(id.getText().toString()))
            {
                firstName.setError("Field must be full");
                firstName.setHintTextColor(Color.RED);
            }
            else
            SearchCostumer();

        }
    }


}