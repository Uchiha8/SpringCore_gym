package dao.implementation;

import dao.BaseDAO;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Optional<User> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public User create(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
