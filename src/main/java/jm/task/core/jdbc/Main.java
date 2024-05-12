package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("a", "b", (byte) 33);
        userService.saveUser("b", "b", (byte) 33);
        userService.saveUser("c", "b", (byte) 33);
        userService.saveUser("d", "b", (byte) 33);
        userService.getAllUsers();
        userService.removeUserById(2);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
