package com.likelion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() {
        String dbHost = "jdbc:mysql://localhost:3306/test-db";
        String dbUser = "";
        String dbPassword = "";
        try {
            Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
            return conn;

        }catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
