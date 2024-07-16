package com.gl.exercise.demo.Entity;


public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String address;
    private String PhoneNumber;

    public Customer(int customerId, String name, String email, String address, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
        PhoneNumber = phoneNumber;
    }

    public Customer() {

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
