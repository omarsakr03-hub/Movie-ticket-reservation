package com.example.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasecontroller {
    private static final String URL = "jdbc:mysql://localhost:3306/cinema_booking"; // Change to your database name
    private static final String USER = "root"; // Change to your database username
    private static final String PASSWORD = "123456789"; // Change to your database password

    public Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection to the database established successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // Optional: Method to close the connection
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                System.out.println("Failed to close the connection!");
                e.printStackTrace();
            }
        }
    }

}