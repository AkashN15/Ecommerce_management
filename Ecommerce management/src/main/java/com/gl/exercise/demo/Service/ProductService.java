package com.gl.exercise.demo.Service;

import com.gl.exercise.demo.Entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public String addProduct(Product product) throws SQLException;
    public List<Product> getAllProducts() throws SQLException;
    public void udpateQuantity(int id, int qua) throws SQLException;

    public String deleteProduct(int id) throws SQLException;
}
