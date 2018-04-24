package com.example.user.carrentalapplication.controller;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.carrentalapplication.R;
import com.example.user.carrentalapplication.model.backend.DBManagerFactory;
import com.example.user.carrentalapplication.model.entities.Branch;

import java.util.List;

public class GetBranchesActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_branches);
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
                protected ArrayAdapter<Branch> doInBackground(Void... params) {
                    final List<Branch> branches = DBManagerFactory.getManager().getAllBrunches();

                    return new ArrayAdapter<Branch>(getBaseContext(), R.layout.item_branch_view, branches) {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            if (convertView == null)
                                convertView = View.inflate(GetBranchesActivity.this, R.layout.item_branch_view, null);
                            TextView address = (TextView) convertView.findViewById(R.id.addressView);
                            TextView num = (TextView) convertView.findViewById(R.id.numView);
                            TextView place = (TextView) convertView.findViewById(R.id.placeView);

                            address.setText("Address: " + branches.get(position).getAdress());
                            place.setText("Parking Place: " + ((Integer) branches.get(position).getNumberOfParkingSpaces()).toString());
                            num.setText("Branch Number: " + ((Integer) branches.get(position).getBranchNumber()).toString());

                            return convertView;

                        }
                    };
                }
            }.execute();
        }catch (Exception e){}



    }
    void setListAdapter(ListAdapter branch)
    {
        ListView listView = new ListView(this);
        listView.setAdapter(branch);
        this.setContentView(listView);
    }



}

