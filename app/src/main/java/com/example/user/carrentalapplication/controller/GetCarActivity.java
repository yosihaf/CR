package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.datasource.MySQL_DBManager;
import com.example.user.carrentalapplication.model.entities.Car;

import java.util.List;

public class GetCarActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_car);

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
               protected ArrayAdapter<Car> doInBackground(Void... params) {
                   final List<Car> cars = DBManagerFactory.getManager().getAllCars();
                   return new ArrayAdapter<Car>(getBaseContext(), R.layout.item_car_view, cars) {
                       @Override
                       public View getView(int position, View convertView, ViewGroup parent) {
                           if (convertView == null)
                               convertView = View.inflate(GetCarActivity.this, R.layout.item_car_view, null);
                           TextView numBranch = (TextView) convertView.findViewById(R.id.branchNumberView);
                           TextView numModel = (TextView) convertView.findViewById(R.id.modelNumView);
                           TextView km = (TextView) convertView.findViewById(R.id.kilometersView);
                           TextView numCar = (TextView) convertView.findViewById(R.id.carNumberView);
                           numBranch.setText("Branch Number: " + DBManagerFactory.getManager().ReturnBranchById((Integer) cars.get(position).getBranchNumber()).getAdress());
                          // numBranch.setText("Branch Number: " + ((Integer) cars.get(position).getBranchNumber()).toString());
                           numModel.setText("Model Number: " + DBManagerFactory.getManager().ReturnModelById((Long) cars.get(position).getModel()).getModel());
                           //numModel.setText("Model Number: " + ((Long) cars.get(position).getModel()).toString());
                           km.setText("Km: " + ((Long) cars.get(position).getKilometers()).toString());
                           numCar.setText("Car Number: " + ((Long) cars.get(position).getCarNumber()).toString());


                           return convertView;

                       }
                   };
               }
           }.execute();
       } catch (Exception e) {
       }
   }

    void setListAdapter(ListAdapter cars)
    {
        ListView listView = new ListView(this);
        listView.setAdapter(cars);
        this.setContentView(listView);
    }


}
