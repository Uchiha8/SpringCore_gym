package service.implementation;

import dao.implementation.TrainingTypeDAO;
import domain.TrainingType;
import org.springframework.stereotype.Service;
import service.BaseService;
import utils.exception.ValidatorException;
import utils.validation.impl.TrainingTypeErrorValidator;

import java.util.List;

@Service
public class TrainingTypeService implements BaseService<TrainingType> {
    private final TrainingTypeDAO trainingTypeDAO;
    private final TrainingTypeErrorValidator trainingTypeErrorValidator;

    public TrainingTypeService(TrainingTypeDAO trainingTypeDAO, TrainingTypeErrorValidator trainingTypeErrorValidator) {
        this.trainingTypeDAO = trainingTypeDAO;
        this.trainingTypeErrorValidator = trainingTypeErrorValidator;
    }

    @Override
    public List<TrainingType> readAll() {
        return trainingTypeDAO.readAll();
    }

    @Override
    public TrainingType readById(Long id) {
        return trainingTypeDAO.readById(id);
    }

    @Override
    public TrainingType create(TrainingType createRequest) {
        if (trainingTypeErrorValidator.isValidParams(createRequest)) {
            return trainingTypeDAO.create(createRequest);
        }
        throw new ValidatorException("Something is wrong");
    }

    @Override
    public TrainingType update(TrainingType updateRequest) {
        if (trainingTypeErrorValidator.isValidParams(updateRequest)) {
            return trainingTypeDAO.update(updateRequest);
        }
        throw new ValidatorException("Something is wrong");
    }

    @Override
    public boolean deleteById(Long id) {
        return trainingTypeDAO.deleteById(id);
    }
}
