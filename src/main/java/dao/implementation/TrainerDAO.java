package dao.implementation;

import dao.BaseDAO;
import domain.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.DataSource;
import utils.exception.TrainerNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TrainerDAO implements BaseDAO<Trainer> {

    private final DataSource dataSource;

    @Autowired
    public TrainerDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Trainer> readAll() {
        Map<Long, Trainer> trainerMap = dataSource.readAllTrainer();
        return new ArrayList<>(trainerMap.values());
    }

    @Override
    public Trainer readById(Long id) {
        Map<Long, Trainer> trainerMap = dataSource.readAllTrainer();
        if (existById(id)) {
            return trainerMap.get(id);
        }
        throw new TrainerNotFoundException(id);
    }

    @Override
    public Trainer create(Trainer entity) {
        Map<Long, Trainer> trainerMap = dataSource.readAllTrainer();
        trainerMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Trainer update(Trainer entity) {
        Map<Long, Trainer> trainerMap = dataSource.readAllTrainer();
        if (existById(entity.getId())) {
            trainerMap.put(entity.getId(), entity);
            return entity;
        }
        throw new TrainerNotFoundException(entity.getId());
    }

    @Override
    public boolean deleteById(Long id) {
        Map<Long, Trainer> trainerMap = dataSource.readAllTrainer();
        if (existById(id)) {
            trainerMap.remove(id);
            return true;
        }
        throw new TrainerNotFoundException(id);
    }

    @Override
    public boolean existById(Long id) {
        Map<Long, Trainer> trainerMap = dataSource.readAllTrainer();
        return trainerMap.containsKey(id);
    }
}
