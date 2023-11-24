package dao.implementation;

import dao.BaseDAO;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.DataSource;
import utils.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Repository
public class UserDAO implements BaseDAO<User> {

    private final DataSource dataSource;

    @Autowired
    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<User> readAll() {
        Map<Long, User> userMap = dataSource.readAllUser();
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User readById(Long id) {
        Map<Long, User> userMap = dataSource.readAllUser();
        if (userMap != null) {
            User user = userMap.get(id);
            if (user != null) {
                return user;
            }
        }
        throw new UserNotFoundException(id);

    }

    @Override
    public User create(User entity) {
        Map<Long, User> userMap = dataSource.readAllUser();
        generateUsernamePassword(entity);
        userMap.put(entity.getId(), entity);
        User user = userMap.get(entity.getId());
        if (user != null) {
            return user;
        }
        throw new RuntimeException("This user can not be registered");
    }

    @Override
    public User update(User entity) {
        Long id = entity.getId();
        Map<Long, User> userMap = dataSource.readAllUser();
        if (existById(id)) {
            userMap.put(id, entity);
            return entity;
        } else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        Map<Long, User> userMap = dataSource.readAllUser();
        if (existById(id)) {
            userMap.remove(id);
            return true;
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public boolean existById(Long id) {
        Map<Long, User> userMap = dataSource.readAllUser();
        return userMap.containsKey(id);
    }

    private void generateUsernamePassword(User user) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        user.setPassword(password.toString());
        String username = user.getFirstName() + "." + user.getLastName();
        Map<Long, User> userMap = dataSource.readAllUser();
        boolean status = true;
        List<User> userList = readAll();
        for (User u : userList) {
            int ser = 1;
            String temp = u.getFirstName() + "." + u.getLastName();
            if (temp.equals(username)) {
                username = username + ser;
            } else {
                ser++;
            }
        }
        user.setUsername(username);
    }
}
