package com.line.dao;

import com.line.connection.DBConnection;

import java.sql.Connection;

public class AWSUserDaoImpl extends UserDaoAbstract{
    @Override
    public Connection makeConnection() {
        Connection conn = DBConnection.getConnection();
        return conn;
    }
}
