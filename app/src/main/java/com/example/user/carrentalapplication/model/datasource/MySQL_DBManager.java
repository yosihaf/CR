package com.example.user.carrentalapplication.model.datasource;

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

    private String WEB_URL ="http://crottenb.vlab.jct.ac.il/crottenb/";

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
        return false;
    }

    @Override
    public Boolean addCustomer(Customer values) {
        return null;
    }

    @Override
    public long addCarModel(CarModel values)
    {
        try {
            String result = PHPtools.POST(WEB_URL + "/addStudent.php", values);
            long id = Long.parseLong(result);
            if (id > 0)
                SetUpdate();
            printLog("addStudent:\n" + result);
            return id;
        } catch (IOException e) {
            printLog("addStudent Exception:\n" + e);
            return -1;
        }

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
        return null;
    }

    @Override
    public List<Branch> getAllBrunches() {

            List<Branch> result = new ArrayList<Branch>();
            try
            {
                String str = PHPtools.GET(WEB_URL + "/getBranches.php");
                JSONArray array = new JSONObject(str).getJSONArray("branches");
                for (int i = 0; i < array.length(); i++)
                {
                    JSONObject jsonObject = array.getJSONObject(i);
                    Branch branch = new Branch();
                    branch.setBranchNumber(jsonObject.getInt("_id"));
                    branch.setAdress(jsonObject.getString("address"));
                    branch.setNumberOfParkingSpaces(jsonObject.getInt("spaces"));
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
