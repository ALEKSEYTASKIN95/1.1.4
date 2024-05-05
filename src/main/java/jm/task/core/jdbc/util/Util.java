package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение установлено");

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных");
            throw new RuntimeException(e);
        }
        return connection;
    }
}
