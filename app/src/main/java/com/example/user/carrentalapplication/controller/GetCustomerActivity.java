package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.Customer;

import java.util.List;

public class GetCustomerActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_customer);

        initItemByListView();
    }

    private void initItemByListView() {


        try {
            new AsyncTask<Void, Void, ArrayAdapter>() {

                @Override
                protected void onPostExecute(ArrayAdapter arrayAdapter) {
                    setListAdapter(arrayAdapter);
                }

                @Override
                protected ArrayAdapter<Customer> doInBackground(Void... params) {
                    final List<Customer> cusomers = DBManagerFactory.getManager().getAllCustomers();
                    return new ArrayAdapter<Customer>(getBaseContext(), R.layout.item_customer_view, cusomers) {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            if (convertView == null)
                                convertView = View.inflate(GetCustomerActivity.this, R.layout.item_customer_view, null);
                            TextView lastName = (TextView) convertView.findViewById(R.id.lastNameView);
                            TextView firstName = (TextView) convertView.findViewById(R.id.firstNameView);
                            TextView id = (TextView) convertView.findViewById(R.id.idView);
                            TextView phoneNumber = (TextView) convertView.findViewById(R.id.phoneNumberView);
                            TextView email = (TextView) convertView.findViewById(R.id.emailView);
                            TextView creditCard = (TextView) convertView.findViewById(R.id.creditCardView);
                            lastName.setText("  Last Name: " + cusomers.get(position).getLastName().toString());
                            firstName.setText("  First Name: " + cusomers.get(position).getFirstName().toString());
                            id.setText("  ID: " + ((Long) cusomers.get(position).getId()).toString());
                            phoneNumber.setText("  Phone Number:  0" + ((Long) cusomers.get(position).getPhoneNumber()).toString());
                            email.setText("  Email Number: " + (cusomers.get(position).getEmail()).toString());
                            creditCard.setText("  Branch Number: " + ((Long) cusomers.get(position).getCreditCard()).toString());


                            return convertView;

                        }
                    };
                }
            }.execute();
        } catch (Exception e) {
        }
    }


    void setListAdapter(ListAdapter customer) {
        ListView listView = new ListView(this);
        listView.setAdapter(customer);
        this.setContentView(listView);
    }
}