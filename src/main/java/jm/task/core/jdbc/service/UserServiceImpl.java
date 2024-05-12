package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();


    public void createUsersTable() {
        userDao.createUsersTable();
        System.out.println("Table users created");
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
        System.out.println("Table users deleted");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        System.out.println("User with name " + name + " add in table users");

    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
        System.out.println("User with id " + id + "was deleted");

    }

    public List<User> getAllUsers() {
        System.out.println(userDao.getAllUsers());
        return userDao.getAllUsers();

    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        System.out.println("Table users is clear");
    }
}
