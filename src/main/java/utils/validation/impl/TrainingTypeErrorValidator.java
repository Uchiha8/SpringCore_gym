package utils.validation.impl;

import domain.TrainingType;
import org.springframework.stereotype.Component;
import utils.exception.ValidatorException;
import utils.validation.Validator;

@Component
public class TrainingTypeErrorValidator implements Validator<TrainingType> {
    @Override
    public boolean isValidParams(TrainingType entity) {
        if (entity.getId() == null) {
            throw new ValidatorException("ID cannot be null");
        } else if (entity.getName() == null) {
            throw new ValidatorException("The name of the type cannot be null");
        }
        return true;
    }
}
