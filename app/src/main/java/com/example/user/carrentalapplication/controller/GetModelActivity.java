package com.example.user.carrentalapplication.controller;

import android.app.Activity;
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
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Customer;

import java.util.List;

import static com.example.user.carrentalapplication.R.string.firstName;

public class GetModelActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_model);

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
                protected ArrayAdapter<CarModel> doInBackground(Void... params) {
                    final List<CarModel> models = DBManagerFactory.getManager().getAllModels();
                    return new ArrayAdapter<CarModel>(getBaseContext(), R.layout.item_model_view, models) {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            if (convertView == null)
                                convertView = View.inflate(GetModelActivity.this, R.layout.item_model_view, null);
                            TextView code = (TextView) convertView.findViewById(R.id.codeView);
                            TextView company = (TextView) convertView.findViewById(R.id.companyView);
                            TextView model = (TextView) convertView.findViewById(R.id.modelView);
                            TextView engineCapacity = (TextView) convertView.findViewById(R.id.engineCapacityView);
                            TextView gear = (TextView) convertView.findViewById(R.id.gearView);
                            TextView seats = (TextView) convertView.findViewById(R.id.seatsView);
                            code.setText("  Code: " + ((Long)models.get(position).getCode()).toString());
                            company.setText("  Company: " + models.get(position).getCompany().toString());
                            model.setText("  Model: " +  models.get(position).getModel().toString());
                            engineCapacity.setText(" Engine Capacity:  0" + ((Long) models.get(position).getEngineCapacity()).toString());
                            gear.setText(" Gear: " + (models.get(position).getGear()).toString());
                            seats.setText("  Seats: " + ((Integer) models.get(position).getSeats()).toString());


                            return convertView;

                        }
                    };
                }
            }.execute();
        } catch (Exception e) {
        }
    }

    void setListAdapter(ListAdapter model) {
        ListView listView = new ListView(this);
        listView.setAdapter(model);
        this.setContentView(listView);
    }
}
