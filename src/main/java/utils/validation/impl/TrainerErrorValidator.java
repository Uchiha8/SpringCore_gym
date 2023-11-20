package utils.validation.impl;

import domain.Trainer;
import org.springframework.stereotype.Component;
import utils.exception.ValidatorException;
import utils.validation.Validator;

@Component
public class TrainerErrorValidator implements Validator<Trainer> {

    @Override
    public boolean isValidParams(Trainer entity) {
        if (entity.getId() == null) {
            throw new ValidatorException("Some thing wrong with id");
        } else if (entity.getUserId() == null) {
            throw new ValidatorException("Some thing wrong with user_id");
        } else if (entity.getSpecialization() == null) {
            throw new ValidatorException("Some thing wrong with specialization");
        }
        return true;
    }
}
