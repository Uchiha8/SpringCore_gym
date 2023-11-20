package dao.implementation;

import dao.BaseDAO;
import domain.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.DataSource;
import utils.exception.TrainingNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TrainingDAO implements BaseDAO<Training> {
    private final DataSource dataSource;

    @Autowired
    public TrainingDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Training> readAll() {
        Map<Long, Training> trainingMap = dataSource.readAllTraining();
        return new ArrayList<>(trainingMap.values());
    }

    @Override
    public Training readById(Long id) {
        Map<Long, Training> trainingMap = dataSource.readAllTraining();
        if (existById(id)) {
            return trainingMap.get(id);
        }
        throw new TrainingNotFoundException(id);
    }

    @Override
    public Training create(Training entity) {
        Map<Long, Training> trainingMap = dataSource.readAllTraining();
        trainingMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Training update(Training entity) {
        Map<Long, Training> trainingMap = dataSource.readAllTraining();
        if (existById(entity.getId())) {
            trainingMap.put(entity.getId(), entity);
            return entity;
        }
        throw new TrainingNotFoundException(entity.getId());
    }

    @Override
    public boolean deleteById(Long id) {
        Map<Long, Training> trainingMap = dataSource.readAllTraining();
        if (existById(id)) {
            trainingMap.remove(id);
            return true;
        }
        throw new TrainingNotFoundException(id);
    }

    @Override
    public boolean existById(Long id) {
        Map<Long, Training> trainingMap = dataSource.readAllTraining();
        if (trainingMap.containsKey(id)) {
            return true;
        }
        return false;
    }
}
