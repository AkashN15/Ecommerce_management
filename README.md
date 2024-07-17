To run the project follow the steps:

-> Download the folder from github repository
-> Extract the files from the zip file
-> Open the folder inthe intellij platform
-> If the jdk17 is already is not downloaded then it show the link to download in the platform itself
-> open  MYSQL command line and enter your ROOT Password
-> create a database using command 
            "create database ecommerce;"
-> connect to the created database using command 
            "connect ecommerce;"
-> create customer table 
          "CREATE TABLE Customer (customer_id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(100) NOT NULL,email VARCHAR(100),address TEXT,phone_number VARCHAR(20))";
-> create products table
          "CREATE TABLE Product (product_id INT AUTO_INCREMENT PRIMARY KEY,name VARCHAR(255) NOT NULL,description TEXT,price INT NOT NULL,quantity_available INT NOT NULL,category VARCHAR(100))";
-> create orders table
          "CREATE TABLE `Order` (order_id INT AUTO_INCREMENT PRIMARY KEY,customer_id INT,product_id INT,quantity INT NOT NULL,order_date VARCHAR(50) NOT NULL,status VARCHAR(20) DEFAULT 'Pending',  FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),FOREIGN KEY (product_id) REFERENCES Product(product_id));"
->In INTELLIJ platform open "src/main/com.gl.exercise.demo/Util/DataBaseConn.java" 
-> Update the password with your root password
-> Run App.java


