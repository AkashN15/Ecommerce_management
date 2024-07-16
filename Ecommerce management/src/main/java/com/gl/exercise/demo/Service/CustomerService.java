package com.gl.exercise.demo.Service;

import com.gl.exercise.demo.Entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    public String addCustomerDetails(Customer customer) throws SQLException;
    public List<Customer> getAllCustomers() throws SQLException;
    public void deleteCustomerById(int id) throws SQLException;
    public void updateCustomerName(int id, String name) throws SQLException;
}
