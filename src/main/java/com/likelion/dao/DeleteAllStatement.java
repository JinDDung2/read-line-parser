package com.likelion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStatement implements StatementStrategy{
    @Override
    public PreparedStatement makePreparedStatement(Connection conn) throws SQLException {
        String sql = "DELETE FROM users";
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps;
    }
}
