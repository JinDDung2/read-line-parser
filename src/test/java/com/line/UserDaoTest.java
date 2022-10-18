package com.line;

import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserDaoTest {


    @Test
    void addAndSelect() {
        UserDao userDao = new UserDao();
        User user = new User("8", "EternityHwan", "1234");
        userDao.add(user);

        User findUser = userDao.findById("8");
        Assertions.assertEquals("EternityHwan", findUser.getName());
    }
}