package com.likelion.dao;

import java.sql.Connection;

public interface ConnectionMaker {
    Connection makeConnection();
}
