package service.implementation;

import dao.implementation.UserDAO;
import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    UserDAO userDAO;

    UserService userService;

    @BeforeEach
    public void setUp() {
        userDAO = Mockito.mock(UserDAO.class);
        userService = Mockito.mock(UserService.class);
    }

    @Test
    void readAll() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1L, "firstName1", "LastName1", "Username1", "password1", true);
        User user2 = new User(2L, "firstName2", "LastName2", "Username2", "password2", true);
        User user3 = new User(3L, "firstName3", "LastName3", "Username3", "password3", true);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Mockito.when(userDAO.readAll()).thenReturn(users);

        List<User> test_users = userService.readAll();
        Assertions.assertEquals(3, test_users.size());
        Assertions.assertEquals("firstName2", test_users.get(2).getFirstName());
    }
}
