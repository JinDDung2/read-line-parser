package com.likelion.dao;

import com.likelion.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final DataSource dataSource;
    private final JdbcContext jdbcContext;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcContext = new JdbcContext(dataSource);
    }

    public void save(User user) {
        jdbcContext.workWithStatementStrategy(
                new StatementStrategy() {
                    @Override
                    public PreparedStatement makePreparedStatement(Connection conn) throws SQLException {
                        String sql = "INSERT INTO users(id, name, password) values(?, ?, ?)";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setString(1, user.getId());
                        ps.setString(2, user.getName());
                        ps.setString(3, user.getPassword());
                        return ps;
                    }
                }
        );
    }

    public User findById(String id) {
        String sql = "select * from users where users.id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
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
        jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection conn) throws SQLException {
                String sql = "DELETE FROM users";
                PreparedStatement ps = conn.prepareStatement(sql);
                return ps;
            }
        });
    }

    public int getCount(){
        String sql = "SELECT count(*) FROM users";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            close(conn, ps, rs);
        }
    }

    // 가변인자로 받아서, 파라미터를 여러개 받는다.
    private void close(AutoCloseable... autoCloseable) {
        for (AutoCloseable ac : autoCloseable) {
            if (ac != null) {
                try {
                    ac.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
