package com.example.user.carrentalapplication.model.backend;

/**
 * Created by User on 12/04/2018.
 */
import android.content.ContentValues;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Customer;
import com.example.user.carrentalapplication.model.entities.Gearbox;

import java.util.Objects;

public class CarRentalConst {
    public static class CustomerConst{
        public static final String LAST_NAME = "lastName";
        public static final String FIRST_NAME = "firstName";
        public static final String ID = "_id";
        public static final String PHONE = "phoneNumber";
        public static final String EMAIL = "email";
        public static final String CREDIT_CARD = "creditCard";

    }

    public static class BrunchConst{
        public static final String ADRESS = "Adress";
        public static final String NUMBER_OF_PARKING_SPACE = "NumberOfParkingSpaces";
        public static final String BRUNCH_NUMBER = "_id";
    }

    public static class CarModelConst{
        public static final String CODE = "_id";
        public static final String COMPANY = "company";
        public static final String MODEL = "model";
        public static final String ENGINE_CAPACITY = "engineCapacity";
        public static final String GEAR = "gear";
        public static final String SEATS = "seats";
    }

    public static class CarConst{
        public static final String BRUNCH_NUMBER = "_id";
        public static final String MODEL = "model";
        public static final String KILOMETERS = "kilometers";
        public static final String CAR_NUMBER = "carNumber";

    }

    public static class OrderhConst{
        public static final String CUSTOMER_ORDER = "customerOrder";
        public static final String STATUS = "status";
        public static final String NUM_OF_CARS = "numOfCars";
        public static final String RENTAL_START = "rentalStart";
        public static final String RENTAL_FINISH = "rentalFinish";
        public static final String KILOMETER_START  = "kilometerStart";
        public static final String KILOMETER_FINISH = "kilometerFinish";
        public static final String FUEL = "fuel";
        public static final String LITER = "liter";
        public static final String BILLING = "billing";
        public static final String ORDER_NUM = "_id";

    }

    public static ContentValues CustomerToContentValues(Customer customer) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CustomerConst.ID, customer.getId());
        contentValues.put(CustomerConst.FIRST_NAME, customer.getFirstName());
        contentValues.put(CustomerConst.LAST_NAME, customer.getLastName());
        contentValues.put(CustomerConst.PHONE, customer.getPhoneNumber());
        contentValues.put(CustomerConst.EMAIL, customer.getEmail());
        contentValues.put(CustomerConst.CREDIT_CARD, customer.getCreditCard());
        return contentValues;
    }


    public static Customer ContentValuesToCustomer(ContentValues contentValues) {

        Customer customer = new Customer();
        customer.setId(contentValues.getAsLong(CustomerConst.ID));
        customer.setFirstName(contentValues.getAsString(CustomerConst.FIRST_NAME));
        customer.setLastName(contentValues.getAsString(CustomerConst.LAST_NAME));
        customer.setPhoneNumber(contentValues.getAsLong(CustomerConst.PHONE));
        customer.setEmail(contentValues.getAsString(CustomerConst.EMAIL));
        customer.setCreditCard(contentValues.getAsLong(CustomerConst.CREDIT_CARD));
        return customer;
    }

    public static ContentValues BrunchToContentValues(Branch branch) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(BrunchConst.ADRESS, branch.getAdress());
        contentValues.put(BrunchConst.NUMBER_OF_PARKING_SPACE, branch.getNumberOfParkingSpaces());
        contentValues.put(BrunchConst.BRUNCH_NUMBER, branch.getBranchNumber());

        return contentValues;
    }


    public static Branch ContentValuesToBrunch(ContentValues contentValues) {

        Branch brunch = new Branch();
        brunch.setAdress(contentValues.getAsString(BrunchConst.ADRESS));
        brunch.setNumberOfParkingSpaces(contentValues.getAsInteger(BrunchConst.NUMBER_OF_PARKING_SPACE));
        brunch.setBranchNumber(contentValues.getAsInteger(BrunchConst.BRUNCH_NUMBER));

        return brunch;
    }

    public static ContentValues CarModelToContentValues(CarModel carModel) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarModelConst.CODE, carModel.getCode());
        contentValues.put(CarModelConst.COMPANY, carModel.getCompany());
        contentValues.put(CarModelConst.MODEL, carModel.getModel());
        contentValues.put(CarModelConst.ENGINE_CAPACITY, carModel.getEngineCapacity());
        contentValues.put(CarModelConst.GEAR, carModel.getGear().toString());
        contentValues.put(CarModelConst.SEATS, carModel.getSeats());

        return contentValues;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static CarModel ContentValuesToCarModel(ContentValues contentValues) {

        CarModel carModel = new CarModel();
        carModel.setCode(contentValues.getAsLong(CarModelConst.CODE));
        carModel.setCompany(contentValues.getAsString(CarModelConst.COMPANY));
        carModel.setModel(contentValues.getAsString(CarModelConst.MODEL));
        carModel.setEngineCapacity(contentValues.getAsLong(CarModelConst.ENGINE_CAPACITY));
        if(Objects.equals(contentValues.getAsString(CarModelConst.GEAR), Gearbox.AUTOMATIC.toString()))
            carModel.setGear(Gearbox.AUTOMATIC);
        else
            carModel.setGear(Gearbox.MANUAL);
        carModel.setSeats(contentValues.getAsInteger(CarModelConst.SEATS));

        return carModel;
    }

    public static ContentValues CarToContentValues(Car car) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(CarConst.BRUNCH_NUMBER, car.getBranchNumber());
        contentValues.put(CarConst.MODEL, car.getModel());
        contentValues.put(CarConst.KILOMETERS, car.getKilometers());
        contentValues.put(CarConst.CAR_NUMBER, car.getCarNumber());

        return contentValues;
    }


    public static Car ContentValuesToCar(ContentValues contentValues) {

        Car car = new Car();
        car.setBranchNumber(contentValues.getAsInteger(CarConst.BRUNCH_NUMBER));
        car.setCarNumber(contentValues.getAsInteger(CarConst.MODEL));
        car.setKilometers(contentValues.getAsInteger(CarConst.KILOMETERS));
        car.setCarNumber(contentValues.getAsInteger(CarConst.CAR_NUMBER));

        return car;
    }





}
