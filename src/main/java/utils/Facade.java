package utils;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.implementation.UserService;

import java.util.List;

@Component
public class Facade {
    private final UserService userService;

    @Autowired
    public Facade(UserService userService) {
        this.userService = userService;
    }

    public List<User> readAllUser() {
        return userService.readAll();
    }

}
