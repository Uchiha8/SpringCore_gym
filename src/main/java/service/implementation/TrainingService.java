package service.implementation;

import dao.implementation.TrainingDAO;
import domain.Training;
import org.springframework.stereotype.Service;
import service.BaseService;
import utils.validation.impl.TrainingErrorValidator;

import java.util.List;

@Service
public class TrainingService implements BaseService<Training> {

    private final TrainingDAO trainingDAO;
    private final TrainingErrorValidator trainingErrorValidator;

    public TrainingService(TrainingDAO trainingDAO, TrainingErrorValidator trainingErrorValidator) {
        this.trainingDAO = trainingDAO;
        this.trainingErrorValidator = trainingErrorValidator;
    }

    @Override
    public List<Training> readAll() {
        return trainingDAO.readAll();
    }

    @Override
    public Training readById(Long id) {
        return trainingDAO.readById(id);
    }

    @Override
    public Training create(Training createRequest) {
        if (trainingErrorValidator.isValidParams(createRequest)) {
            return trainingDAO.create(createRequest);
        }
        throw new RuntimeException("Some thing is wrong with provided entity");
    }

    @Override
    public Training update(Training updateRequest) {
        if (trainingErrorValidator.isValidParams(updateRequest)) {
            return trainingDAO.update(updateRequest);
        }
        throw new RuntimeException("Some thing is wrong with provided entity");
    }

    @Override
    public boolean deleteById(Long id) {
        return trainingDAO.deleteById(id);
    }
}
