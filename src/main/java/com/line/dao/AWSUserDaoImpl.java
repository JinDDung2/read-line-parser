package com.line.dao;

import com.line.connection.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.line.connection.ConnectionConst.*;

public class AWSUserDaoImpl extends UserDaoAbstract{
    @Override
    public Connection makeConnection() {
        try {
            Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
            return conn;

        }catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
