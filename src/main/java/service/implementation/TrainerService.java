package service.implementation;

import dao.implementation.TrainerDAO;
import domain.Trainer;
import org.springframework.stereotype.Service;
import service.BaseService;
import utils.exception.ValidatorException;
import utils.validation.impl.TrainerErrorValidator;

import java.util.List;

@Service
public class TrainerService implements BaseService<Trainer> {

    private final TrainerDAO trainerDAO;

    private final TrainerErrorValidator trainerErrorValidator;

    public TrainerService(TrainerDAO trainerDAO, TrainerErrorValidator traineeErrorValidator) {
        this.trainerDAO = trainerDAO;
        this.trainerErrorValidator = traineeErrorValidator;
    }

    @Override
    public List<Trainer> readAll() {
        return trainerDAO.readAll();
    }

    @Override
    public Trainer readById(Long id) {
        return trainerDAO.readById(id);
    }

    @Override
    public Trainer create(Trainer createRequest) {
        if (trainerErrorValidator.isValidParams(createRequest)) {
            return trainerDAO.create(createRequest);
        }
        throw new RuntimeException("Some thing wrong validator");
    }

    @Override
    public Trainer update(Trainer updateRequest) {
        if (trainerErrorValidator.isValidParams(updateRequest)) {
            return trainerDAO.update(updateRequest);
        }
        throw new ValidatorException("SOme thing wrong with provided entity");
    }

    @Override
    public boolean deleteById(Long id) {
        return trainerDAO.deleteById(id);
    }
}
