package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.sql.Select;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String...args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Andrew", "Ivanov", (byte) 20);
        userService.saveUser("Alex", "Sunny", (byte) 39);
        userService.saveUser("Pavel", "Petrov", (byte) 18);
        userService.saveUser("Andre", "Popov", (byte) 35);

//        userService.getAllUsers();
//
//        userService.cleanUsersTable();
//
//        userService.dropUsersTable();


    }
}

