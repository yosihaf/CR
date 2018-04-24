package com.example.user.carrentalapplication.model.datasource;

import  android.content.ContentValues;
import android.os.Build;
import android.support.annotation.RequiresApi;


import com.example.user.carrentalapplication.model.backend.CarRentalConst;
import com.example.user.carrentalapplication.model.backend.DB_manager;
import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Customer;

import java.util.ArrayList;
import java.util.List;

import static com.example.user.carrentalapplication.model.backend.CarRentalConst.*;
/**
 * Created by User on 12/04/2018.
 */

public class List_DBManager implements DB_manager {

    private static List<Customer> customers;
    private static List<Branch> brunches;
    private static List<CarModel> carModels;
    private static List<Car> cars;

    static {
        customers = new ArrayList<>();
        brunches = new ArrayList<>();
        brunches.add(new Branch("haifa",100,12));

        carModels = new ArrayList<>();
        cars = new ArrayList<>();
    }

    @Override
    public boolean custumerExsits(Customer values) {
        return false;
    }

    @Override
    public long addCustomer(Customer values) {
        customers.add(values);
        return values.getId();
    }

    @Override
    public long addCarModel(CarModel values) {
        carModels.add(values);
        return values.getCode();
    }

    @Override
    public long addCar(Car values) {
        cars.add(values);
        return values.getCarNumber();
    }

    @Override
    public List<CarModel> getAllModels() {
        return carModels;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public List<Branch> getAllBrunches() {
        return brunches;
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
    /*
    @Override
    public boolean custumerExsits(ContentValues values) {
        return false;
    }

    @Override
    public long addCustomer(ContentValues values) {
        Customer customer = ContentValuesToCustomer(values);
        customers.add(customer);
        return customer.getId();
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public long addCarModel(ContentValues values) {
        CarModel carModel = ContentValuesToCarModel(values);
        carModels.add(carModel);
        return carModel.getCode();
    }

    @Override
    public long addCar(ContentValues values) {
        Car car = ContentValuesToCar(values);
        cars.add(car);
        return car.getCarNumber();
    }

    @Override
    public List<CarModel> getAllModels() {
        return carModels;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public List<Branch> getAllBrunches() {
        return brunches;
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
    */


}
