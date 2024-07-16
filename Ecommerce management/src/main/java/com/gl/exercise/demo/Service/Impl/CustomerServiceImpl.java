package com.gl.exercise.demo.Service.Impl;


import com.gl.exercise.demo.Entity.Customer;
import com.gl.exercise.demo.Service.CustomerService;
import com.gl.exercise.demo.Util.DataBaseConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public String addCustomerDetails(Customer customer) throws SQLException {

        Connection connection = DataBaseConn.getConnection();
        String sql = "INSERT INTO Customer (customer_id, name, email, address,phone_number) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customer.getCustomerId());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setString(4, customer.getAddress());
        preparedStatement.setString(5, customer.getPhoneNumber());

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            return "Customer added successfully with ID: " + customer.getCustomerId();
        } else {
            return "Failed to add customer.";
        }


    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {

        List<Customer> list = new ArrayList<>();
        Connection con = DataBaseConn.getConnection();
        Statement stmt = con.createStatement();
        String query = "Select * from Customer";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            String address = rs.getString(4);
            String phone = rs.getString(5);

            list.add(new Customer(id, name, email, address, phone));
        }

        return list;
    }

    @Override
    public void deleteCustomerById(int id) throws SQLException {

        String DELETE_PRODUCT_SQL = "DELETE FROM customer WHERE customer_id = ?";
        Connection con = DataBaseConn.getConnection();
        PreparedStatement stmt = con.prepareStatement(DELETE_PRODUCT_SQL);
        int productIdToDelete = 2;
        stmt.setInt(1, productIdToDelete);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Customer with ID " + productIdToDelete + " deleted successfully.");
        } else {
            System.out.println("No customer found with ID " + productIdToDelete);
        }


    }

    @Override
    public void updateCustomerName(int id, String name) throws SQLException {
        String UPDATE_CUSTOMER_NAME_SQL = "UPDATE customer SET name = ? WHERE customer_id = ?";
        Connection con = DataBaseConn.getConnection();
        PreparedStatement stmt = con.prepareStatement(UPDATE_CUSTOMER_NAME_SQL);

        // Set parameters (customer name and ID) for the prepared statement
        stmt.setString(1, name);
        stmt.setInt(2, id);

        // Execute the update statement
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Customer with ID " + id + " name updated to '" + name + "' successfully.");
        } else {
            System.out.println("No customer found with ID " + id);
        }
    }
}