package com.likelion.dao;

import com.likelion.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UserDao {

    private final JdbcTemplate template;

    public UserDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper() {
        return ((rs, rowNum) -> {
            User user = new User(rs.getString("id"),
                    rs.getString("name"), rs.getString("password"));
            return user;
        });
    }

    public void save(User user) {
        String sql = "INSERT INTO users(id, name, password) VALUES(?, ?, ?)";
        template.update(sql, user.getId(), user.getName(), user.getPassword());
    }

    public User findById(String id) {
        String sql = "select * from users where users.id=?";
        return template.queryForObject(sql, userRowMapper(), id);
    }

    public List<User> getAll() {
        String sql = "SELECT * from users ORDER BY id";
        return template.query(sql, userRowMapper());
    }

    public void deleteAll() {
        String sql = "DELETE FROM users";
        template.update(sql);
    }

    public int getCount(){
        String sql = "SELECT count(*) FROM users";
        return template.queryForObject(sql, Integer.class);
    }

}
