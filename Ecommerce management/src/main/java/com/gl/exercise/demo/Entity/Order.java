package com.gl.exercise.demo.Entity;

public class Order {
    private int orderId;
    private int customer_id;
    private int product_id;
    private int quantity;
    private String order_date;
    private String status;

    public Order(int orderId, int customer_id, int product_id, int quantity, String order_date, String status) {
        this.orderId = orderId;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.order_date = order_date;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
