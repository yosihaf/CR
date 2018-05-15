package com.example.user.carrentalapplication.model.backend;

import android.content.ContentValues;

import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Customer;
import com.example.user.carrentalapplication.model.entities.User;

import java.util.List;

/**
 * Created by User on 12/04/2018.
 */

public interface DB_manager {
    /*
    boolean custumerExsits(ContentValues values);
    long addCustomer(ContentValues values);
    long addCarModel(ContentValues values);
    long addCar(ContentValues values);
    List<CarModel> getAllModels();
    List<Customer> getAllCustomers();
    List<Branch> getAllBrunches();
    List<Car> getAllCars();
    */
    boolean AddUser(User user);
    List<User> getAllUsers();

    boolean carExists(Long values);
    boolean carModelExists(Long values);
    boolean custumerExsits(Customer values);
    Boolean addCustomer(Customer values);
    long addCarModel(CarModel values);
    long addCar(Car values);
    List<CarModel> getAllModels();
    List<Customer> getAllCustomers();
    List<Branch> getAllBrunches();
    List<Car> getAllCars();





}
