package com.line.dao;

import com.line.connection.MySQLConnection;

import java.sql.Connection;

public class AWSUserDaoImpl extends UserDaoAbstract{
    @Override
    public Connection makeConnection() {
        Connection conn = MySQLConnection.getConnection();
        return conn;
    }
}
