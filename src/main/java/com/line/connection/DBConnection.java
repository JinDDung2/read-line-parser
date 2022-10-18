package com.line.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.line.connection.ConnectionConst.*;


public class DBConnection {

    public DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
            return conn;

        }catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

}
