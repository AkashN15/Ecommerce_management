package com.gl.exercise.demo.Service.Impl;


import com.gl.exercise.demo.Entity.Product;
import com.gl.exercise.demo.Service.ProductService;
import com.gl.exercise.demo.Util.DataBaseConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public String addProduct(Product product) throws SQLException {

        try {


            Connection connection = DataBaseConn.getConnection();
            String sql = "INSERT INTO Product (product_id, name, description, price, quantity_available, category) VALUES (?,?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getQuantityAvailable());
            preparedStatement.setString(6, product.getCategory());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return "Product added successfully with ID: " + product.getProductId();
            } else {
                return "Failed to add product.";
            }
        } catch (SQLException e) {
            System.out.println("error in inserting data");
        }
        return "Product added Successfully" + product.getProductId();


    }

    @Override
    public List<Product> getAllProducts() throws SQLException {

        List<Product> list=new ArrayList<>();
        Connection con= DataBaseConn.getConnection();
        Statement stmt=con.createStatement();
        String query="Select * from Product";
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next())
        {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            String des=rs.getString(3);
            int price=rs.getInt(4);
            int qua=rs.getInt(5);
            String cat=rs.getString(6);

            list.add(new Product(id,name,des,price,qua,cat));
        }
        return list;
    }

    @Override
    public String deleteProduct(int id) throws SQLException {

        String DELETE_PRODUCT_SQL = "DELETE FROM product WHERE product_id = ?";
        Connection con= DataBaseConn.getConnection();
        PreparedStatement stmt = con.prepareStatement(DELETE_PRODUCT_SQL);
        int productIdToDelete = 2;
        stmt.setInt(1, productIdToDelete);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Product with ID " + productIdToDelete + " deleted successfully.");
        } else {
            System.out.println("No product found with ID " + productIdToDelete);
        }


        return "Product Deleted Successfully";
    }

    @Override
    public void udpateQuantity(int id, int qua) throws SQLException {
        String UPDATE_PRODUCT_QUANTITY_SQL = "UPDATE product SET quantity_available = ? WHERE product_id = ?";
        Connection con= DataBaseConn.getConnection();
        PreparedStatement stmt = con.prepareStatement(UPDATE_PRODUCT_QUANTITY_SQL);
        stmt.setInt(1, qua);
        stmt.setInt(2, id);

        // Execute the update statement
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Product with ID " + id + " quantity updated to " + qua + " successfully.");
        } else {
            System.out.println("No product found with ID " + id);
        }

    }
}