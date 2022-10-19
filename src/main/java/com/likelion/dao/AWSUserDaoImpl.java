package com.likelion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.likelion.connection.ConnectionConst.*;

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
