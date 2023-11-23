package service.implementation;

import dao.implementation.UserDAO;
import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import utils.validation.impl.UserErrorValidator;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Mock
    UserDAO userDAO;
    @Mock
    UserErrorValidator userErrorValidator;

    @InjectMocks
    UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
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
        Assertions.assertEquals("firstName3", test_users.get(2).getFirstName());
    }

    @Test
    void readById() {
        Long id = 2L;
        User user = new User(2L, "Muhammad", "Najimov", "Axes#13", "nothing", true);
        Mockito.when(userDAO.readById(id)).thenReturn(user);
        User test_user = userService.readById(id);
        Assertions.assertEquals(user, test_user);
        Assertions.assertEquals("Najimov", test_user.getLastName());
    }

    @Test
    void create() {
        User creatRequest = new User(4L, "Alisher", "Bobojonov", "Nigger", "BigBoy", false);
        Mockito.when(userErrorValidator.isValidParams(creatRequest)).thenReturn(true);
        Mockito.when(userDAO.create(creatRequest)).thenReturn(creatRequest);

        User saved_user = userService.create(creatRequest);
        Assertions.assertNotEquals(null, saved_user);
        Assertions.assertEquals("Alisher", saved_user.getFirstName());
    }

    @Test
    void update() {
        Long id = 1L;
        User existingUser = new User(1L, "ALisher", "Bobojonov", "nothing", "1dan8gacha", true);
        User updatedUser = new User(1L, "ALisher", "Bobojonov", "2110107", "11111111", false);
        Mockito.when(userErrorValidator.isValidParams(updatedUser)).thenReturn(true);
        Mockito.when(userDAO.update(existingUser)).thenReturn(updatedUser);

        User user = userService.update(updatedUser);
        Assertions.assertEquals("2110107", user.getUsername());
        Assertions.assertEquals("11111111", user.getPassword());
    }

    @Test
    void deleteById() {
        Long id = 2L;
        Mockito.when(userDAO.deleteById(id)).thenReturn(true);
        boolean result = userService.deleteById(id);
        Mockito.verify(userDAO, Mockito.times(1)).deleteById(id);
        Assertions.assertTrue(result);
    }
}
