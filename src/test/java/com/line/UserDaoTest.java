package com.line;

import com.line.dao.AWSUserDaoImpl;
import com.line.dao.UserDao;
import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserDaoTest {


    @Test
    void addAndSelect() {
        UserDao userDao = new UserDao();
        User user = new User("11", "IVE", "1234");
        userDao.add(user);

        User findUser = userDao.findById("11");
        Assertions.assertEquals("IVE", findUser.getName());
    }
}