package dao.implementation;

import dao.BaseDAO;
import domain.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.DataSource;

import java.util.*;

@Repository
public class TraineeDAO implements BaseDAO<Trainee> {

    private final DataSource dataSource;

    @Autowired
    public TraineeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Trainee> readAll() {
        Map<Long, Trainee> traineeMap = dataSource.readAllTrainee();
        return new ArrayList<>(traineeMap.values());
    }

    @Override
    public Optional<Trainee> readById(Long id) {
        Map<Long, Trainee> traineeMap = dataSource.readAllTrainee();
        if (traineeMap.containsKey(id)) {
            return Optional.of(traineeMap.get(id));
        }
        throw new RuntimeException();
    }

    @Override
    public Trainee create(Trainee entity) {
        return null;
    }

    @Override
    public Trainee update(Trainee entity) {
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
