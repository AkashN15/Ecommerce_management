package com.gl.exercise.demo;

import com.gl.exercise.demo.Entity.Customer;
import com.gl.exercise.demo.Entity.Order;
import com.gl.exercise.demo.Entity.Product;
import com.gl.exercise.demo.Service.CustomerService;
import com.gl.exercise.demo.Service.Impl.CustomerServiceImpl;
import com.gl.exercise.demo.Service.Impl.OrderServiceImpl;
import com.gl.exercise.demo.Service.Impl.ProductServiceImpl;
import com.gl.exercise.demo.Service.OrderService;
import com.gl.exercise.demo.Service.ProductService;
import com.gl.exercise.demo.Util.DataBaseConn;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to E-Commerce Platform");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Orders");
            System.out.println("3. Manage Customers");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            sc.nextLine();
            switch (choice) {
                case 1:
                    productsManagement();
                    break;
                case 2:
                    ordersManagement();
                    break;
                case 3:
                    customerManagement();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }


    private  static void productsManagement() throws SQLException {

        ProductService productService=new ProductServiceImpl();

        while (true) {
            System.out.println("\nPRODUCT MANAGEMENT");
            System.out.println("1. Add New Product");
            System.out.println("2. View Product Details");
            System.out.println("3. Update Product Information");
            System.out.println("4. Delete Product");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            Scanner sc=new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // Implement add product functionality
                    System.out.println(("Enter Product Name: "));
                    String name=sc.nextLine();
                    System.out.println("Enter Product description");
                    String dec=sc.nextLine();
                    System.out.println("Enter Product price");
                    int price=sc.nextInt();
                    System.out.println("Enter Product quantityAvailable");
                    int quantityAvailable=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Product category");
                    String category=sc.nextLine();

                    Product product=new Product(DataBaseConn.generateUniqueId("product_id ","product",1),name,dec,price,quantityAvailable,category);
                    String s=productService.addProduct(product);
                    System.out.println(s);
                    break;
                case 2:
                    // Implement view product details functionality
                    List<Product> list=new ArrayList<>();
                    list=productService.getAllProducts();
                    for (int i = 0; i < list.size(); i++) {
                        Product product1 = list.get(i);

                        System.out.println( product1.getProductId());
                        System.out.println( product1.getName());
                        System.out.println(  product1.getDescription());
                        System.out.println( product1.getPrice());
                        System.out.println( product1.getQuantityAvailable());
                        System.out.println(  product1.getCategory());

                    }

                    break;
                case 3:
                    System.out.println("Enter Product id :");
                    int id2=sc.nextInt();
                    System.out.println("Enter quantity :");
                    int quaa=sc.nextInt();
                    productService.udpateQuantity(id2,quaa);
                    System.out.println("Product udpated successfully");
                    // Implement update product information functionality
                    break;
                case 4:
                    // Implement delete product functionality

                    System.out.println("Enter Product id :");
                    int id=sc.nextInt();
                    String str=productService.deleteProduct(id);
                    System.out.println("Product with id :"+id+"has deleted successfully");
                    break;
                case 5:
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    public static void customerManagement() throws SQLException{

        CustomerService customerService=new CustomerServiceImpl();

        while(true)
        {
            System.out.println("/nCustomer Management");
            System.out.println("1. Register new customers");
            System.out.println("2. View customer details");
            System.out.println("3. Update customer information");
            System.out.println("4. Delete customers");
            Scanner sc=new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter customer name");
                    String name=sc.nextLine();
                    System.out.println("Enter email :");
                    String email=sc.nextLine();
                    System.out.println("Enter address :");
                    String address=sc.nextLine();
                    System.out.println("Enter Phone Number :");
                    String phone=sc.nextLine();
                    Customer customer=new Customer(DataBaseConn.generateUniqueId("customer_id","customer",1),name,email,address,phone);
                    String str=customerService.addCustomerDetails(customer);
                    break;
                case 2:
                    List<Customer> list=new ArrayList<>();
                    list=customerService.getAllCustomers();
                    for (int i = 0; i < list.size(); i++) {
                        Customer customer1 = list.get(i);

                        System.out.println("Order ID: " + customer1.getCustomerId());
                        System.out.println("Customer ID: " + customer1.getName());
                        System.out.println("Product ID: " + customer1.getEmail());
                        System.out.println("Quantity: " + customer1.getAddress());
                        System.out.println("Date: " + customer1.getPhoneNumber());

                    }
                    break;
                case 3:
                    System.out.println("Enter id:");
                    int id=sc.nextInt();
                    System.out.println("Update order status :");
                    String st=sc.nextLine();
                    customerService.updateCustomerName(id,st);
                    System.out.println("Order status udpated Successfully");

                    break;
                case 4:
                    System.out.println("Enter Customer id :");
                    int id1=sc.nextInt();
                    customerService.deleteCustomerById(id1);
                    System.out.println("Customer deleted Successfully");
                    break;

            }


        }

    }

    public static void ordersManagement()throws SQLException{
        OrderService orderService=new OrderServiceImpl();

        while (true)
        {
            System.out.println("/n Orders Management");
            System.out.println("1. Place new orders");
            System.out.println("2. View order details");
            System.out.println("3. Update order status");
            System.out.println("4. Cancel orders");

            Scanner sc=new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    System.out.println("Enter Customer Id :");
                    int cid=sc.nextInt();
                    System.out.println("Enter Product Id :");
                    int pid=sc.nextInt();
                    System.out.println("Enter Quantity :");
                    int quantity=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Today's Date :");
                    String date=sc.nextLine();
                    String s="";
                    Order order=new Order(DataBaseConn.generateUniqueId("order_id","`Order`",0),cid,pid,quantity,date,s);
                    String str=orderService.getOrder(order);
                    System.out.println("ordered successfully");
                    break;
                case 2:
                    List<Order> list=new ArrayList<>();
                    list=orderService.GetAllOrders();
                    for (int i = 0; i < list.size(); i++) {
                        Order orderr = list.get(i);

                        System.out.println("Order ID: " + orderr.getOrderId());
                        System.out.println("Customer ID: " + orderr.getCustomer_id());
                        System.out.println("Product ID: " + orderr.getProduct_id());
                        System.out.println("Quantity: " + orderr.getQuantity());
                        System.out.println("Date: " + orderr.getOrder_date());
                        System.out.println("Status: " + orderr.getStatus());

                    }
                    break;
                case 3:
                    System.out.println("Enter id:");
                    int id=sc.nextInt();
                    System.out.println("Update order status :");
                    String st=sc.nextLine();
                    orderService.updateOrderStatus(id,st);
                    System.out.println("Order status udpated Successfully");

                    break;
                case 4:
                    System.out.println("Enter order id :");
                    int idd=sc.nextInt();
                    orderService.deleteOrderById(idd);
                    System.out.println("Order deleted Successfully");
                    break;
            }
        }

    }
}
