package com.example.user.carrentalapplication.model.datasource;

import android.content.ContentValues;
import android.provider.SyncStateContract;
import android.util.Log;

import com.example.user.carrentalapplication.model.backend.DB_manager;
import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Customer;
import com.example.user.carrentalapplication.model.entities.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AAA on 26/04/2018.
 */

public class MySQL_DBManager implements DB_manager {

    private String WEB_URL ="http://crottenb.vlab.jct.ac.il/CR/";

    @Override
    public boolean AddUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Customer ReturnCustumerById(String values) {
        return null;
    }

    @Override
    public boolean ReturnCarById(Long values) {
        return false;
    }

    @Override
    public boolean ReturnCarModelById(Long values) {
        return false;
    }

    @Override
    public boolean custumerExsits(Customer values) {
           return  false;
    }

    @Override
    public Boolean addCustomer(Customer values) {

        try {
            getAllCustomers();
            String url = WEB_URL + "addCustomer.php" ;

            final ContentValues v = new ContentValues();
            v.put( "_id", values.getId() );
            v.put( "first_name", values.getFirstName() );
            v.put( "last_name", values.getLastName() );
            v.put( "phoneNumber", values.getPhoneNumber() );
            v.put( "email", values.getEmail() );
            v.put( "creditCard", values.getCreditCard() );

            PHPtools.POST( url, v );
        } catch (Exception e) {
            //Log.w( Constants.Log.APP_LOG, e.getMessage() );
        }
        return true;
    }

    @Override
    public long addCarModel(CarModel values)
    {

return values.getCode();
    }

    @Override
    public long addCar(Car values) {
        return 0;
    }

    @Override
    public List<CarModel> getAllModels() {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> result = new ArrayList<Customer>();
        try
        {
            String str = PHPtools.GET(WEB_URL + "/getCustomer.php");
            JSONArray array = new JSONObject(str).getJSONArray("customer");
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);
                Customer customer = new Customer();
                customer.setFirstName(jsonObject.getString("first_name"));
                customer.setLastName(jsonObject.getString("last_name"));
                customer.setCreditCard(jsonObject.getInt("creditCard"));
                customer.setEmail(jsonObject.getString("email"));
                customer.setPhoneNumber(jsonObject.getString("phoneNumber"));

                result.add(customer);
            }
            return result;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Branch> getAllBrunches() {

            List<Branch> result = new ArrayList<Branch>();
            try
            {
                String str = PHPtools.GET(WEB_URL + "getBranches.php");
                JSONArray array = new JSONObject(str).getJSONArray("branches");
                for (int i = 0; i < array.length(); i++)
                {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Branch branch = new Branch();
                    branch.setBranchNumber(jsonObject.getInt("_id"));
                    branch.setAdress(jsonObject.getString("address"));
                    branch.setNumberOfParkingSpaces(jsonObject.getInt("space"));
                    result.add(branch);
                }
                return result;
            } catch (Exception e)
            {
                e.printStackTrace();
            }     return null;
        }



    @Override
    public List<Car> getAllCars() {
        return null;
    }
}
