package com.example.user.carrentalapplication.model.datasource;


import com.example.user.carrentalapplication.model.backend.DB_manager;
import com.example.user.carrentalapplication.model.entities.Branch;
import com.example.user.carrentalapplication.model.entities.Car;
import com.example.user.carrentalapplication.model.entities.CarModel;
import com.example.user.carrentalapplication.model.entities.Customer;
import com.example.user.carrentalapplication.model.entities.Gearbox;
import com.example.user.carrentalapplication.model.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/04/2018.
 */

public class List_DBManager implements DB_manager {

    private static List<Customer> customers;
    private static List<Branch> brunches;
    private static List<CarModel> carModels;
    private static List<Car> cars;
    private static List<User> users;

    static
    {
        customers = new ArrayList<>();
        customers.add(new Customer("yoseff","haf","30898987824","0323","yoseff2525@gmail.com",9));
        customers.add(new Customer("ert","qwer","232278732","1231323","yosef@gmail.com",2));
        customers.add(new Customer("yoseff","haf","3024","0323","yo@gmail.com",8));
        customers.add(new Customer("yoseff","haf","3024","0323","yoseff25@gmail.com",6));
        brunches = new ArrayList<>();
        brunches.add(new Branch("haifa",100,12));
        brunches.add(new Branch("Tel Aviv",1033,1233));
        brunches.add(new Branch("bny braq",11111,22222));

        carModels = new ArrayList<>();
        carModels.add(new CarModel( 123,  "company3","ford",  1234, Gearbox.AUTOMATIC, 123 ));
        carModels.add(new CarModel( 1234,  "company2","mazda",  1222, Gearbox.AUTOMATIC, 1231234 ));
        carModels.add(new CarModel( 124566,  "company1","er",  124565, Gearbox.MANUAL, 12323 ));

        cars = new ArrayList<>();
        cars.add(new Car( 124566,  13455644,23,  124565));
        cars.add(new Car( 566,  12123444,144,  124565));
        cars.add(new Car( 24566,  1244,106,  10992));
        cars.add(new Car( 1266,  1344,107,  1098));

        users = new ArrayList<>();

    }

    @Override
    public boolean AddUser(User user) {
        users.add(user);
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }


    @Override
    public Customer ReturnCustumerById(String values)
    {
        for (Customer item:customers) {
            if(item.getId().equals(values) )
                return item;
        }
        return null;
    }

    @Override
    public Branch ReturnBranchById(Integer values) {
        for (Branch item:brunches) {
            if(item.getBranchNumber()==(values) )
                return item;
        }
        return null;
    }
    @Override
    public CarModel ReturnModelById(Long values) {
        for (CarModel item:carModels) {
            if(item.getCode()==(values) )
                return item;
        }
        return null;
    }

    @Override
    public boolean custumerExsits(Customer values) {
        if(customers.contains(values))
            return true;
        return false;
    }

    @Override
    public boolean branchExists(int values) {
        for (Branch item:brunches) {
            if(item.getBranchNumber()==values )
                return true;
        }
        return false;
    }

    @Override
    public boolean carExists(Long values){
        for (Car item:cars) {
            if(item.getCarNumber()==values )
                return true;
        }
        return false;
    }
    @Override
    public boolean carModelExists(Long values)
    {
        for (CarModel item:carModels) {
            if(item.getCode()==values )
                return true;
        }
        return false;
    }

    @Override
    public Boolean addCustomer(Customer values) {
        if (ReturnCustumerById(values.getId()) != null)
            return false;
        customers.add(values);
        return true;
    }

    @Override
    public long addBranch(Branch values) {
        if (branchExists(values.getBranchNumber()) == true)
            return -1;
        brunches.add(values);
        return values.getBranchNumber();
    }

    @Override
    public long addCarModel(CarModel values) {
        if (carModelExists(values.getCode()) == true)
            return -1;
        carModels.add(values);
        return values.getCode();
    }

    @Override
    public long addCar(Car values) {
        if (carExists(values.getCarNumber()) == true)
            return -1;
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
