package com.line.dao;

import com.line.connection.DBConnectionUtil;

import java.sql.Connection;

public class AWSUserDaoImpl extends UserDaoAbstract{
    @Override
    public Connection makeConnection() {
        Connection conn = DBConnectionUtil.getConnection();
        return conn;
    }
}
