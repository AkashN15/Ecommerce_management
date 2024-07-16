package com.gl.exercise.demo.Util;

import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DataBaseConn {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static  AtomicInteger counter=new AtomicInteger(0);

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection Established");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int generateUniqueId(String columnName, String tableName, int initialValue) {
        Connection conn = getConnection();
        int uniqueId = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX(" + columnName + ") AS max_id FROM " + tableName);
            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                counter = new AtomicInteger(maxId > 0 ? maxId : initialValue);
            } else {
                counter = new AtomicInteger(initialValue);
            }
            uniqueId = counter.incrementAndGet();
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniqueId;
    }
}
