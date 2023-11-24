package utils;

import domain.Trainee;
import domain.Training;
import domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.implementation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class Facade {

    private static Logger logger = LogManager.getLogger(Facade.class);

    private final UserService userService;
    private final TraineeService traineeService;
    private final TrainerService trainerService;
    private final TrainingTypeService trainingTypeService;
    private final TrainingService trainingService;

    @Autowired
    public Facade(UserService userService, TraineeService traineeService, TrainerService trainerService, TrainingTypeService trainingTypeService, TrainingService trainingService) {
        this.userService = userService;
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingTypeService = trainingTypeService;
        this.trainingService = trainingService;
    }


    public void readAll() {
        List<User> usersList = userService.readAll();
        logger.info("List of Users\n");
        logger.info(usersList.toString());

    }


    public void UserCRUD() {
        List<User> userList = userService.readAll();
        for (User u : userList) {
            System.out.println(u.toString());
        }
        System.out.println("============/READ BY ID/===========");
        Long id = 2L;
        User userById = userService.readById(id);
        System.out.println(userById.toString());
        System.out.println("============/CREAT NEW USER/===========");
        User new_user = new User(4L, "Abdulaziz", "Yakubganov", "fearless", "1324five", false);
        System.out.println(userService.create(new_user).toString());
        System.out.println("============/READ ALL USER/===========");
        List<User> users = userService.readAll();
        for (User u : users) {
            System.out.println(u.toString());
        }
        System.out.println("============/UPDATE USER/===========");
        User update_user = new User(1L, "Natig", "Kurbanov", "coolman", "confidential", true);
        System.out.println(userService.update(update_user).toString());
        System.out.println("============/READ ALL USER/===========");
        List<User> updated_users = userService.readAll();
        for (User u : updated_users) {
            System.out.println(u.toString());
        }
        System.out.println("============/DELETE USER/===========");
        Long delete_Id = 4L;
        System.out.println(userService.deleteById(delete_Id));
        System.out.println("============/READ ALL USER/===========");
        List<User> users4 = userService.readAll();
        for (User u : users4) {
            System.out.println(u.toString());
        }
    }

    public void TraineeCRUD() {
        System.out.println("==========/READ ALL TRAINEE/===========");
        List<Trainee> traineeList = traineeService.readAll();
        for (Trainee trainee : traineeList) {
            System.out.println(trainee.toString());
        }
        System.out.println("==========/READ TRAINEE BY ID/===========");
        Long id = 1L;
        Trainee traineeById = traineeService.readById(id);
        System.out.println(traineeById.toString());
        System.out.println("==========/CREAT NEW TRAINEE/===========");
        Trainee create_trainee = new Trainee(4L, LocalDate.of(2002, 11, 23), "12, Oqtepa district", 2L);
        System.out.println(traineeService.create(create_trainee).toString());
        System.out.println("==========/READ ALL TRAINEE/===========");
        List<Trainee> traineeList_new = traineeService.readAll();
        for (Trainee trainee : traineeList_new) {
            System.out.println(trainee.toString());
        }
        System.out.println("==========/UPDATE TRAINEE/===========");
        Trainee update_trainee = new Trainee(2L, LocalDate.of(2002, 10, 20), "New York", 2L);
        System.out.println(traineeService.update(update_trainee).toString());
        System.out.println("==========/READ ALL TRAINEE/===========");
        List<Trainee> updated_trainees = traineeService.readAll();
        for (Trainee trainee : updated_trainees) {
            System.out.println(trainee.toString());
        }
        System.out.println("============/DELETE TRAINEE/===========");
        Long delete_Id = 1L;
        System.out.println(traineeService.deleteById(delete_Id));
        System.out.println("==========/READ ALL TRAINEE/===========");
        List<Trainee> trainee_afterDeletion = traineeService.readAll();
        for (Trainee trainee : trainee_afterDeletion) {
            System.out.println(trainee.toString());
        }
    }

    public void TrainingCRUD() {
        System.out.println("===========/READ ALL TRAININGS/==========");
        List<Training> trainingList = trainingService.readAll();
        for (Training t : trainingList) {
            System.out.println(t.toString());
        }
        System.out.println("===========/READ BY ID/==========");
        Long id = 2L;
        System.out.println(traineeService.readById(id));
        System.out.println("===========/CREAT NEW TRAINING/==========");
        Training training = new Training(4L, 1L, 2L, "Avengers", 1L, LocalDateTime.of(2023, 11, 13, 10, 30), 2);
        System.out.println(trainingService.create(training).toString());
        System.out.println("===========/READ ALL TRAININGS/==========");
        List<Training> trainingList1 = trainingService.readAll();
        for (Training t : trainingList1) {
            System.out.println(t.toString());
        }
        System.out.println("===========/UPDATE TRAINING/==========");
        Training training_update = new Training(4L, 1L, 2L, "Updated Name", 1L, LocalDateTime.of(2023, 10, 13, 14, 30), 2);
        System.out.println(trainingService.update(training_update).toString());
        System.out.println("===========/READ ALL TRAININGS/==========");
        List<Training> trainingList2 = trainingService.readAll();
        for (Training t : trainingList2) {
            System.out.println(t.toString());
        }
        System.out.println("===========/DELETE TRAINING BY ID/==========");
        Long deleteID = 2L;
        System.out.println(trainingService.deleteById(deleteID));
        System.out.println("===========/READ ALL TRAININGS/==========");
        List<Training> trainingList3 = trainingService.readAll();
        for (Training t : trainingList3) {
            System.out.println(t.toString());
        }
    }

}
