import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {
    private final UserDao userDao = new UserDaoJDBCImpl();

    private final String testName = "Ivan";
    private final String testLastName = "Ivanov";
    private final byte testAge = 5;


    @Test
    public void dropUsersTable() {
        try {
            userDao.createUsersTable();
            userDao.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
        }
    }

    @Test
    public void createUsersTable() {
        try {
            userDao.createUsersTable();
            userDao.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
        try {

            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);

            User user = userDao.getAllUsers().get(0);

            if (!testName.equals(user.getName())
                    || !testLastName.equals(user.getLastName())
                    || testAge != user.getAge()
            ) {
                Assert.fail("User был некорректно добавлен в базу данных");
            }
            userDao.dropUsersTable();

        } catch (Exception e) {
            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
        }
    }

    @Test
    public void removeUserById() {
        try {
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            userDao.removeUserById(1L);
            userDao.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
        }
    }

    @Test
    public void getAllUsers() {
        try {

            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            List<User> userList = userDao.getAllUsers();


            if (userList.size() != 1) {
                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
            userDao.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
            userDao.createUsersTable();
            userDao.saveUser(testName, testLastName, testAge);
            userDao.cleanUsersTable();


            if (userDao.getAllUsers().size() != 0) {
                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
            }
            userDao.dropUsersTable();
        } catch (Exception e) {
            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
        }
    }

}
