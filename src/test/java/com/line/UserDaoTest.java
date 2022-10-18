package com.line;

import com.line.dao.AWSUserDaoImpl;
import com.line.dao.UserDao;
import com.line.dao.UserDaoAbstract;
import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserDaoTest {


    @Test
    void addAndSelect() {
        UserDaoAbstract userDao = new AWSUserDaoImpl();
        User user = new User("9", "nine", "1234");
        userDao.add(user);

        User findUser = userDao.findById("9");
        Assertions.assertEquals("nine", findUser.getName());
    }
}