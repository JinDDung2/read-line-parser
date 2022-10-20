package com.likelion.dao;

import com.likelion.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao() {
        this.connectionMaker = new AWSConnectionMaker();
    }

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) {

        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO users(id, name, password) values (?, ?, ?)";
        try {
            conn = connectionMaker.makeConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            close(conn, ps);
        }

    }

    public User findById(String id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from users where users.id=?";

        try {
            conn = connectionMaker.makeConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getString("id"),
                        rs.getString("name"), rs.getString("password"));
                return user;
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            close(conn, ps, rs);
        }
    }

    public void deleteAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from users";

        try {
            conn = connectionMaker.makeConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(conn, ps);
        }
    }

    // 가변인자로 받아서, 파라미터를 여러개 받는다.
    private void close(AutoCloseable... autoCloseable) {
        for (AutoCloseable ac : autoCloseable) {
            try {
                ac.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
