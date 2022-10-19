package com.line;

import com.line.dao.AWSUserDaoImpl;
import com.line.dao.UserDao;
import com.line.dao.UserDaoFactory;
import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserDaoTest {


    @Test
    void addAndSelect() {
        UserDao userDao = new UserDaoFactory().awsUserDao();
        User user = new User("12", "twelve", "1234");
        userDao.add(user);

        User findUser = userDao.findById("12");
        Assertions.assertEquals("twelve", findUser.getName());
    }
}