package utils.exception;

public class TrainingTypeNotFoundException extends RuntimeException {
    public TrainingTypeNotFoundException(Long id) {
        super("Training type not found with ID: " + id);
    }
}
