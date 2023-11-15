package utils;

import domain.*;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSource {
    private Map<Long, User> userMap = new HashMap<>();
    private Map<Long, Trainee> traineeMap = new HashMap<>();
    private Map<Long, Trainer> trainerMap = new HashMap<>();
    private Map<Long, Training> trainingMap = new HashMap<>();
    private Map<Long, TrainingType> trainingTypeMap = new HashMap<>();
    private final String USER_FILE_PATH = "src/main/resources/user.txt";
    private final String TRAINEE_FILE_PATH = "src/main/resources/trainee.txt";
    private final String TRAINER_FILE_PATH = "src/main/resources/trainer.txt";
    private final String TRAINING_FILE_PATH = "src/main/resources/training.txt";
    private final String TRAINING_TYPE_FILE_PATH = "src/main/resources/trainingType.txt";

    public DataSource() {
        init();
    }

    private void init() {
        parseUser();
        parseTrainee();
        parseTrainer();
        parseTrainingType();
        parseTraining();
    }


    void parseUser() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_FILE_PATH));
            String temp;
            Long key = 1L;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] entity = temp.split(":");
                Long id = Long.parseLong(entity[0]);
                String firstName = entity[1];
                String lastName = entity[2];
                String username = entity[3];
                String password = entity[4];
                boolean isActive = entity[5].startsWith("t");
                User user = new User(id, firstName, lastName, username, password, isActive);
                userMap.put(key, user);
                key++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void parseTrainee() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TRAINEE_FILE_PATH));
            String temp;
            Long key = 1L;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] trainee = temp.split(":");
                Long id = Long.parseLong(trainee[0]);
                LocalDate dateOfBirth = LocalDate.parse(trainee[1]);
                String address = trainee[2];
                Long userId = Long.parseLong(trainee[3]);
                Trainee entity = new Trainee(id, dateOfBirth, address, userId);
                traineeMap.put(key, entity);
                key++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void parseTrainer() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TRAINER_FILE_PATH));
            String temp;
            Long key = 1L;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] trainer = temp.split(":");
                Long id = Long.parseLong(trainer[0]);
                Long specializationId = Long.parseLong(trainer[1]);
                Long userId = Long.parseLong(trainer[2]);
                Trainer entity = new Trainer(id, specializationId, userId);
                trainerMap.put(key, entity);
                key++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void parseTrainingType() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TRAINING_TYPE_FILE_PATH));
            String temp;
            Long key = 1L;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] type = temp.split(":");
                Long id = Long.parseLong(type[0]);
                String name = type[1];
                TrainingType trainingType = new TrainingType(id, name);
                trainingTypeMap.put(key, trainingType);
                key++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void parseTraining() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TRAINING_FILE_PATH));
            String temp;
            Long key = 1L;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] training = temp.split(":");
                Long id = Long.parseLong(training[0]);
                Long traineeId = Long.parseLong(training[1]);
                Long trainerId = Long.parseLong(training[2]);
                String trainingName = training[3];
                Long trainingType = Long.parseLong(training[4]);
                LocalDateTime localDateTime = LocalDateTime.of(2023, 11, 13, 17, 00);
                Number duration = (Number) Integer.parseInt(training[5]);
                Training entity = new Training(id, traineeId, trainerId, trainingName, trainingType, localDateTime, duration);
                trainingMap.put(key, entity);
                key++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Long, User> readAllUser() {
        return userMap;
    }

    public Map<Long, TrainingType> readAllTrainingType() {
        return trainingTypeMap;
    }

    public Map<Long, Trainer> readAllTrainer() {
        return trainerMap;
    }

    public Map<Long, Training> readAllTraining() {
        return trainingMap;
    }

    public Map<Long, Trainee> readAllTrainee() {
        return traineeMap;
    }

}
