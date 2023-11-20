package utils.validation.impl;

import domain.Trainee;
import org.springframework.stereotype.Component;
import utils.exception.ValidatorException;
import utils.validation.Validator;

@Component
public class TraineeErrorValidator implements Validator<Trainee> {

    @Override
    public boolean isValidParams(Trainee entity) {
        if (entity.getId() == null) {
            throw new ValidatorException("Illegal argument with id (it can be null or not long)");
        } else if (entity.getUserId() == null) {
            throw new ValidatorException("Illegal argument with user id (it can be null or not long)");
        } else if (entity.getAddress() == null) {
            throw new ValidatorException("Address should be specified)");
        } else if (entity.getDateOfBirth() == null) {
            throw new ValidatorException("Date of birth should be specified)");
        }
        return true;
    }
}
