package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("awd");

        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("a", "b", (byte) 33);
        userDao.saveUser("b", "b", (byte) 33);
        userDao.saveUser("c", "b", (byte) 33);
        userDao.saveUser("d", "b", (byte) 33);
        userDao.getAllUsers();
        userDao.removeUserById(2);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
