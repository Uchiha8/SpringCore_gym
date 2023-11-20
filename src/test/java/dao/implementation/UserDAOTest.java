package dao.implementation;

import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.DataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOTest {
    DataSource dataSource = new DataSource();
    UserDAO userDAO = new UserDAO(dataSource);

    @Test
    void readAll() {
        Map<Long, User> users = new HashMap<>();
        User user1 = new User(1L, "firstName1", "LastName1", "Username1", "password1", true);
        User user2 = new User(2L, "firstName2", "LastName2", "Username2", "password2", true);
        User user3 = new User(3L, "firstName3", "LastName3", "Username3", "password3", true);


    }
}
