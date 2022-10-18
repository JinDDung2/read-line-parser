package com.line.dao;

import java.sql.Connection;

public interface ConnectionMaker {
    Connection makeConnection();
}
