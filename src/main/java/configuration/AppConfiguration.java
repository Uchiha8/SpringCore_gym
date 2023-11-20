package configuration;

import dao.implementation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.implementation.*;
import utils.DataSource;
import utils.Facade;
import utils.validation.impl.*;

@Configuration
public class AppConfiguration {

    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }

    @Bean
    public UserDAO userDAO() {
        DataSource dataSource = new DataSource();
        return new UserDAO(dataSource);
    }

    @Bean
    public TraineeDAO traineeDAO() {
        DataSource dataSource = new DataSource();
        return new TraineeDAO(dataSource);
    }

    @Bean
    public TrainerDAO trainerDAO() {
        DataSource dataSource = new DataSource();
        return new TrainerDAO(dataSource);
    }

    @Bean
    public TrainingDAO trainingDAO() {
        DataSource dataSource = new DataSource();
        return new TrainingDAO(dataSource);
    }

    @Bean
    public TrainingTypeDAO trainingTypeDAO() {
        DataSource dataSource = new DataSource();
        return new TrainingTypeDAO(dataSource);
    }

    @Bean
    public UserService userService() {
        return new UserService(userDAO(), userErrorValidator());
    }

    @Bean
    public TraineeService traineeService() {
        return new TraineeService(traineeDAO(), traineeErrorValidator());
    }

    @Bean
    public TrainerService trainerService() {
        return new TrainerService(trainerDAO(), trainerErrorValidator());
    }

    @Bean
    public TrainingService trainingService() {
        return new TrainingService(trainingDAO(), trainingErrorValidator());
    }

    @Bean
    public TrainingTypeService trainingTypeService() {
        return new TrainingTypeService(trainingTypeDAO(), trainingTypeErrorValidator());
    }

    @Bean
    public TraineeErrorValidator traineeErrorValidator() {
        return new TraineeErrorValidator();
    }

    @Bean
    public UserErrorValidator userErrorValidator() {
        return new UserErrorValidator();
    }

    @Bean
    public TrainerErrorValidator trainerErrorValidator() {
        return new TrainerErrorValidator();
    }

    @Bean
    public TrainingErrorValidator trainingErrorValidator() {
        return new TrainingErrorValidator();
    }

    @Bean
    public TrainingTypeErrorValidator trainingTypeErrorValidator() {
        return new TrainingTypeErrorValidator();
    }

    @Bean
    public Facade facade(UserService userService, TraineeService traineeService, TrainerService trainerService, TrainingService trainingService, TrainingTypeService trainingTypeService) {
        return new Facade(userService, traineeService, trainerService, trainingTypeService, trainingService);
    }

}
