package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.sql.Select;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String...args) {
        Util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();
        userDao.saveUser("Andrew", "Ivanov", (byte) 20);
        userDao.saveUser("Alex", "Sunny", (byte) 39);
        userDao.saveUser("Pavel", "Petrov", (byte) 18);
        userDao.saveUser("Andre", "Popov", (byte) 35);

        userDao.getAllUsers();

        userDao.cleanUsersTable();

        userDao.dropUsersTable();

    }
}
