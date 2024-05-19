package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static SessionFactory sessionFactory = null ;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.driver_class", DRIVER)
                        .setProperty("hibernate.connection.url",URL)
                        .setProperty("hibernate.connection.username",USER)
                        .setProperty("hibernate.connection.password",PASSWORD)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                        .setProperty("current_session_context_class", "thread")
                        .addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory();
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных");
            throw new RuntimeException(e);
        }
        return connection;
    }
}
