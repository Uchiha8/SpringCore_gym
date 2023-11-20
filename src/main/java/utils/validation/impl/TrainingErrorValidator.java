package utils.validation.impl;

import domain.Training;
import org.springframework.stereotype.Component;
import utils.exception.ValidatorException;
import utils.validation.Validator;

@Component
public class TrainingErrorValidator implements Validator<Training> {

    @Override
    public boolean isValidParams(Training entity) {
        if (entity.getId() == null) {
            throw new ValidatorException("ID can not be null");
        } else if (entity.getDuration() == null) {
            throw new ValidatorException("Duration cannot be null");
        } else if (entity.getTrainingDate() == null) {
            throw new ValidatorException("Date of training cannot be null");
        } else if (entity.getTrainingName() == null) {
            throw new ValidatorException("Training name cannot be null");
        } else if (entity.getTraineeId() == null) {
            throw new ValidatorException("Training id cannot be null");
        } else if (entity.getTrainerId() == null) {
            throw new ValidatorException("Trainee id cannot be null");
        }
        return true;
    }
}
