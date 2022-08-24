package com.david.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private Connection connection;

    public Connection createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/emp", "root", "root");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;

    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
