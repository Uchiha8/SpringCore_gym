package service.implementation;

import dao.implementation.TraineeDAO;
import domain.Trainee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.BaseService;
import utils.exception.ValidatorException;
import utils.validation.impl.TraineeErrorValidator;

import java.util.List;
import java.util.Map;

@Service
public class TraineeService implements BaseService<Trainee> {

    private final TraineeDAO traineeDAO;
    private final TraineeErrorValidator traineeErrorValidator;

    public TraineeService(TraineeDAO traineeDAO, TraineeErrorValidator traineeErrorValidator) {
        this.traineeDAO = traineeDAO;
        this.traineeErrorValidator = traineeErrorValidator;
    }

    @Override
    public List<Trainee> readAll() {
        List<Trainee> traineeMap = traineeDAO.readAll();
        if (traineeMap.isEmpty()) {
            System.out.println("The list of the trainee is empty");
        }
        return traineeMap;
    }

    @Override
    public Trainee readById(Long id) {
        return traineeDAO.readById(id);
    }

    @Override
    public Trainee create(Trainee createRequest) {
        if (traineeErrorValidator.isValidParams(createRequest)) {
            traineeDAO.create(createRequest);
            return createRequest;
        }
        throw new ValidatorException("Something wrong with provided entity");
    }

    @Override
    public Trainee update(Trainee updateRequest) {
        if (traineeErrorValidator.isValidParams(updateRequest)) {
            traineeDAO.update(updateRequest);
            return updateRequest;
        }
        throw new ValidatorException("Something wrong with provided entity");
    }

    @Override
    public boolean deleteById(Long id) {
        return traineeDAO.deleteById(id);
    }
}
