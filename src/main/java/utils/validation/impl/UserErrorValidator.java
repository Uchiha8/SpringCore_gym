package utils.validation.impl;

import domain.User;
import org.springframework.stereotype.Component;
import utils.exception.ValidatorException;
import utils.validation.Validator;

@Component
public class UserErrorValidator implements Validator<User> {
    @Override
    public boolean isValidParams(User entity) {
        if (entity.getFirstName() == null) {
            throw new ValidatorException("FirstName should not be null");
        } else if (entity.getLastName() == null) {
            throw new ValidatorException("LastName should not be null");
        } else if (entity.getUsername() == null) {
            throw new ValidatorException("Username should not be null");
        } else if (entity.getPassword() == null) {
            throw new ValidatorException("Password should not be null");
        } else if (entity.getActive() == null) {
            throw new ValidatorException("isActive should not be null");
        }
        return true;
    }
}
