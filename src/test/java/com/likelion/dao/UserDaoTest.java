package com.likelion.dao;

import com.likelion.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserDaoFactory.class)
class UserDaoTest {
    UserDao userDao;

    @Autowired
    ApplicationContext context;

    @BeforeEach
    void setUp() {
        this.userDao = context.getBean("awsUserDao", UserDao.class);
        userDao.deleteAll();
        userDao.save(new User("100", "homidle", "1234"));
        assertEquals(1, userDao.getCount());
    }

    @Test
    void addAndSelect() {
        User user = new User("11", "IVE", "1234");
        userDao.save(user);

        User findUser = userDao.findById("11");
        assertEquals("IVE", findUser.getName());

    }

    @Test
    void countAndDelete() {
        userDao.deleteAll();
        assertEquals(0, userDao.getCount());
    }

    @Test
    void count() {
        userDao.deleteAll();
        assertEquals(0, userDao.getCount());

        User user1 = new User("1", "Chin", "20");
        User user2 = new User("2", "Ck", "21");
        User user3 = new User("3", "Louie", "22");
        userDao.save(user1);
        assertEquals(1, userDao.getCount());

        userDao.save(user2);
        assertEquals(2, userDao.getCount());

        userDao.save(user3);
        assertEquals(3, userDao.getCount());

    }

    @Test
    void findByIdEmpty() {
        assertThrows(RuntimeException.class, () -> {
            userDao.findById("1000");
        });

    }

    @Test
    void getAll() {
        User user1 = new User("1", "Chin", "20");
        User user2 = new User("2", "Ck", "21");
        User user3 = new User("3", "Louie", "22");
        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);

        List<User> users = userDao.getAll();
        assertEquals(4, users.size());

    }
}