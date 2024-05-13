package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {


    public void createUsersTable()  {
        getUserDao().createUsersTable();
    }

    public void dropUsersTable() {
        getUserDao().dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        getUserDao().saveUser(name, lastName, age);
        System.out.println("User с именем - " + name + " добавлен в базу данных");

    }

    public void removeUserById(long id) {
        getUserDao().removeUserById(id);

    }

    public List<User> getAllUsers() {
        List<User> users = getUserDao().getAllUsers();
        System.out.println(users);
        return users;

    }

    public void cleanUsersTable() {
        getUserDao().cleanUsersTable();

    }
}
