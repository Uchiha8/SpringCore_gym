package utils.validation;

public interface Validator<T>{
    boolean isValidParams(T entity);
}
