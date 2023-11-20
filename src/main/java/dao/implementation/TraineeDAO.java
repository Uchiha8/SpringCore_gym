package dao.implementation;

import dao.BaseDAO;
import domain.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.DataSource;
import utils.exception.TraineeNotFoundException;

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
    public Trainee readById(Long id) {
        Map<Long, Trainee> traineeMap = dataSource.readAllTrainee();
        return traineeMap.get(id);
    }

    @Override
    public Trainee create(Trainee entity) {
        Long id = entity.getId();
        Map<Long, Trainee> traineeMap = dataSource.readAllTrainee();
        traineeMap.put(id, entity);
        if (existById(id)) {
            return entity;
        }
        throw new TraineeNotFoundException(entity.getId());
    }

    @Override
    public Trainee update(Trainee entity) {
        Long id = entity.getId();
        Map<Long, Trainee> traineeMap = dataSource.readAllTrainee();
        traineeMap.put(id, entity);
        return entity;
    }

    @Override
    public boolean deleteById(Long id) {
        Map<Long, Trainee> traineeMap = dataSource.readAllTrainee();
        if (existById(id)) {
            traineeMap.remove(id);
            return true;
        }
        throw new TraineeNotFoundException(id);
    }

    @Override
    public boolean existById(Long id) {
        Map<Long, Trainee> traineeMap = dataSource.readAllTrainee();
        return traineeMap.containsKey(id);
    }
}
