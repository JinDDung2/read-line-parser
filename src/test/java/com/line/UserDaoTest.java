package com.line;

import com.line.dao.AWSUserDaoImpl;
import com.line.dao.UserDao;
import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserDaoTest {


    @Test
    void addAndSelect() {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        User user = new User("10", "ten", "1234");
//        userDao.add(user);

        User findUser = userDao.findById("10");
        Assertions.assertEquals("ten", findUser.getName());
    }
}