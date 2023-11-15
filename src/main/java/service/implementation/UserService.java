package service.implementation;

import dao.implementation.UserDAO;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BaseService;

import java.util.List;

@Service
public class UserService implements BaseService<User> {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> readAll() {
        return userDAO.readAll();
    }

    @Override
    public User readById(Long id) {
        return null;
    }

    @Override
    public User create(User createRequest) {
        return null;
    }

    @Override
    public User update(User updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
