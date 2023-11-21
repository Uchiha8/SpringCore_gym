package service.implementation;

import dao.implementation.UserDAO;
import domain.User;
import org.springframework.stereotype.Service;
import service.BaseService;
import utils.exception.ValidatorException;
import utils.validation.impl.UserErrorValidator;

import java.util.List;

@Service
public class UserService implements BaseService<User> {

    private final UserDAO userDAO;
    private final UserErrorValidator userErrorValidator;

    public UserService(UserDAO userDAO, UserErrorValidator userErrorValidator) {
        this.userErrorValidator = userErrorValidator;
        this.userDAO = userDAO;
    }

    @Override
    public List<User> readAll() {
        List<User> userList = userDAO.readAll();
        return userList;
    }

    @Override
    public User readById(Long id) {
        return userDAO.readById(id);
    }

    @Override
    public User create(User createRequest) {
        if (userErrorValidator.isValidParams(createRequest)) {
            userDAO.create(createRequest);
            return createRequest;
        } else {
            throw new ValidatorException("Something wrong with parameters");
        }
    }

    @Override
    public User update(User updateRequest) {
        if (userErrorValidator.isValidParams(updateRequest)) {
            userDAO.update(updateRequest);
            return updateRequest;
        }
        throw new ValidatorException("Something wrong with parameters");
    }

    @Override
    public boolean deleteById(Long id) {
        return userDAO.deleteById(id);
    }
}
