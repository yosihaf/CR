package com.example.user.carrentalapplication.model.entities;

/**
 * Created by User on 11/04/2018.
 */

public class Customer {
    private String lastName;
    private String firstName;
    private long id;
    private long phoneNumber;
    private String email;
    private long creditCard;

    public Customer() {
    }

    public Customer(String lastName, String firstName, long id, long phoneNumber, String email, long creditCard) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creditCard = creditCard;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }
}
