package com.example.user.carrentalapplication.model.datasource;

import android.content.ContentValues;

import com.example.user.carrentalapplication.model.backend.DB_manager;
import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Customer;
import com.example.user.carrentalapplication.model.entities.Gearbox;
import com.example.user.carrentalapplication.model.entities.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AAA on 26/04/2018.
 */



public class MySQL_DBManager implements DB_manager {

    private String WEB_URL ="http://crottenb.vlab.jct.ac.il/CR/";
    private List<Customer> customerList;
    private List<Branch> branchList;
    private List<CarModel> carModelList;
    private List<Car> carList;

    public MySQL_DBManager(){
        customerList = getAllCustomers();
        branchList = getAllBrunches();
        carModelList = getAllModels();
        carList = getAllCars();
    }
    @Override
    public boolean AddUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }



    @Override
    public boolean carExists(Long values) {

        for (Car item:carList) {
            if(item.getCarNumber()==values )
                return true;
        }
        return false;

    }

    @Override
    public boolean carModelExists(Long values) {

        for (CarModel item:carModelList) {
            if(item.getCode()==values )
                return true;
        }
        return false;
    }

    @Override
    public boolean custumerExsits(Customer values) {

        for (Customer item:customerList) {
            if(item.getId().equals(values.getId()) )
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean addCustomer(Customer values) {

        try {

            if(custumerExsits(values)==true)
                return false;
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
        customerList.add(values);
        return true;
    }

    @Override
    public long addCarModel(CarModel values)
    {
        try {

            if(carModelExists(values.getCode())==true)
                return -1;
            String url = WEB_URL + "addModel.php" ;

            final ContentValues v = new ContentValues();
            v.put( "_id", values.getCode() );
            v.put( "company", values.getCompany() );
            v.put( "model", values.getModel() );
            v.put( "enginCapacity", values.getEngineCapacity() );
            v.put( "gear", values.getGear().toString() );
            v.put( "seats", values.getSeats() );

            PHPtools.POST( url, v );

        } catch (Exception e) {
            //Log.w( Constants.Log.APP_LOG, e.getMessage() );
        }
        carModelList.add(values);
        return values.getCode();

    }

    @Override
    public long addCar(Car values) {

        try {

            if(carModelExists(values.getCarNumber())==true)
                return -1;
            String url = WEB_URL + "addCar.php" ;

            final ContentValues v = new ContentValues();
            v.put( "_id", values.getCarNumber() );
            v.put( "branch", values.getBranchNumber() );
            v.put( "model", values.getModel() );
            v.put( "km", values.getKilometers() );
            PHPtools.POST( url, v );

        } catch (Exception e) {
            //Log.w( Constants.Log.APP_LOG, e.getMessage() );
        }
        carList.add(values);
        return values.getCarNumber();

    }

    @Override
    public List<CarModel> getAllModels() {

        if(carModelList != null)
            return carModelList;
        List<CarModel> result = new ArrayList<CarModel>();
        try
        {
            String str = PHPtools.GET(WEB_URL + "getModel.php");
            JSONArray array = new JSONObject(str).getJSONArray("model");
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);
                CarModel model = new CarModel();
                model.setCode(jsonObject.getInt("_id"));
                model.setCompany(jsonObject.getString("company"));
                model.setModel(jsonObject.getString("model"));
                model.setEngineCapacity(jsonObject.getInt("enginCapacity"));
                model.setGear(Gearbox.valueOf((jsonObject.getString("gear"))));
                model.setSeats(jsonObject.getInt("seats"));
                result.add(model);

            }
            return result;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        if(customerList != null)
            return customerList;
        List<Customer> result = new ArrayList<Customer>();
        try
        {
            String str = PHPtools.GET(WEB_URL + "/getCustomer.php");
            JSONArray array = new JSONObject(str).getJSONArray("customer");
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);
                Customer customer = new Customer();
                customer.setId(jsonObject.getString("_id"));
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
        if(branchList != null)
            return branchList;
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
            }
            return null;
        }



    @Override
    public List<Car> getAllCars() {

        if(carList != null)
            return carList;
        List<Car> result = new ArrayList<Car>();
        try
        {
            String str = PHPtools.GET(WEB_URL + "getCar.php");
            JSONArray array = new JSONObject(str).getJSONArray("car");
            for (int i = 0; i < array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);
                Car car = new Car();
                car.setCarNumber(jsonObject.getInt("_id"));
                car.setBranchNumber(jsonObject.getInt("branch"));
                car.setModel(jsonObject.getInt("model"));
                car.setKilometers(jsonObject.getInt("km"));
                result.add(car);
            }
            return result;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
