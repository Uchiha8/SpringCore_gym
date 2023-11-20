package dao.implementation;

import dao.BaseDAO;
import domain.TrainingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.DataSource;
import utils.exception.TrainingTypeNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TrainingTypeDAO implements BaseDAO<TrainingType> {
    private final DataSource dataSource;

    @Autowired
    public TrainingTypeDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<TrainingType> readAll() {
        Map<Long, TrainingType> trainingTypeMap = dataSource.readAllTrainingType();
        return new ArrayList<>(trainingTypeMap.values());
    }

    @Override
    public TrainingType readById(Long id) {
        Map<Long, TrainingType> trainingTypeMap = dataSource.readAllTrainingType();
        if (existById(id)) {
            return trainingTypeMap.get(id);
        }
        throw new TrainingTypeNotFoundException(id);
    }

    @Override
    public TrainingType create(TrainingType entity) {
        Map<Long, TrainingType> trainingTypeMap = dataSource.readAllTrainingType();
        trainingTypeMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public TrainingType update(TrainingType entity) {
        Map<Long, TrainingType> trainingTypeMap = dataSource.readAllTrainingType();
        if (existById(entity.getId())) {
            trainingTypeMap.put(entity.getId(), entity);
            return entity;
        }
        throw new TrainingTypeNotFoundException(entity.getId());
    }

    @Override
    public boolean deleteById(Long id) {
        Map<Long, TrainingType> trainingTypeMap = dataSource.readAllTrainingType();
        if (existById(id)) {
            trainingTypeMap.remove(id);
            return true;
        }
        throw new TrainingTypeNotFoundException(id);
    }

    @Override
    public boolean existById(Long id) {
        Map<Long, TrainingType> trainingTypeMap = dataSource.readAllTrainingType();
        return trainingTypeMap.containsKey(id);
    }
}
