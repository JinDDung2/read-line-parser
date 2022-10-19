package com.likelion;

import com.likelion.dao.UserDao;
import com.likelion.dao.UserDaoFactory;
import com.likelion.domain.User;
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