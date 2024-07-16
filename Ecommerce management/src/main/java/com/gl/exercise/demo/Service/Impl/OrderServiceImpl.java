package com.gl.exercise.demo.Service.Impl;


import com.gl.exercise.demo.Entity.Order;
import com.gl.exercise.demo.Service.OrderService;
import com.gl.exercise.demo.Util.DataBaseConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public String getOrder(Order order) throws SQLException {

        Connection connection = DataBaseConn.getConnection();
        String sql = "INSERT INTO `Order`(order_id, customer_id, product_id, quantity, order_date, status) VALUES (?,?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,order.getOrderId());
        preparedStatement.setInt(2,order.getCustomer_id());
        preparedStatement.setInt(3,order.getProduct_id());
        preparedStatement.setInt(4,order.getQuantity());
        preparedStatement.setString(5,order.getOrder_date());
        preparedStatement.setString(6,"Accepted");

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            return "Order Placed successfully with ID: " + order.getOrderId();
        } else {
            return"Failed to add order.";
        }
    }

    @Override
    public List<Order> GetAllOrders() throws SQLException {
        List<Order> list=new ArrayList<>();
        Connection con=DataBaseConn.getConnection();
        Statement stmt=con.createStatement();
        String query="Select * from `Order`";
        ResultSet rs=stmt.executeQuery(query);

        while(rs.next())
        {
            int id=rs.getInt(1);

            int cid=rs.getInt(2);
            int pid=rs.getInt(3);
            int q=rs.getInt(4);
            String date=rs.getString(5);
            String status=rs.getString(6);
            list.add(new Order(id,cid,pid,q,date,status));

        }
        return list;
    }
    @Override
    public void deleteOrderById(int id) throws SQLException {
        String DELETE_PRODUCT_SQL = "DELETE FROM `order` WHERE order_id = ?";
        Connection con= DataBaseConn.getConnection();
        PreparedStatement stmt = con.prepareStatement(DELETE_PRODUCT_SQL);
        int productIdToDelete = 2;
        stmt.setInt(1, productIdToDelete);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Order with ID " + productIdToDelete + " deleted successfully.");
        } else {
            System.out.println("No Order found with ID " + productIdToDelete);
        }
    }

    @Override
    public void updateOrderStatus(int id,String status) throws SQLException {

        String UPDATE_ORDER_STATUS_SQL = "UPDATE `order` SET status = 'pending' WHERE order_id = ?";
        Connection con= DataBaseConn.getConnection();
        PreparedStatement stmt = con.prepareStatement(UPDATE_ORDER_STATUS_SQL);
        int orderIdToUpdate = 1; // Replace with the actual order ID you want to update
        stmt.setInt(1, orderIdToUpdate);

        // Execute the update statement
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Order with ID " + orderIdToUpdate + " status updated to 'pending' successfully.");
        } else {
            System.out.println("No order found with ID " + orderIdToUpdate);
        }



    }
}
