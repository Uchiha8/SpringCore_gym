package service.implementation;

import dao.implementation.TrainingDAO;
import domain.Training;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import utils.validation.impl.TrainingErrorValidator;

import java.time.LocalDateTime;
import java.util.List;

public class TrainingServiceTest {
    @Mock
    TrainingDAO trainingDAO;
    @Mock
    TrainingErrorValidator trainingErrorValidator;
    @InjectMocks
    TrainingService trainingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void readAll() {
        List<Training> trainingList = trainingDAO.readAll();
        Training training1 = new Training(1L, 1L, 1L, "Avengers", 1L, LocalDateTime.of(2023, 11, 12, 12, 20), 30);
        Training training2 = new Training(2L, 2L, 2L, "BigBoy", 1L, LocalDateTime.of(2023, 11, 12, 14, 20), 30);
        Training training3 = new Training(3L, 3L, 3L, "Anivrap", 2L, LocalDateTime.of(2023, 11, 12, 15, 20), 30);
        trainingList.add(training1);
        trainingList.add(training2);
        trainingList.add(training3);

        Mockito.when(trainingDAO.readAll()).thenReturn(trainingList);

        List<Training> result = trainingService.readAll();
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void readById() {
        Long id = 1L;
        Training training1 = new Training(1L, 1L, 1L, "Avengers", 1L, LocalDateTime.of(2023, 11, 12, 12, 20), 30);
        Mockito.when(trainingDAO.readById(id)).thenReturn(training1);
        Training result = trainingService.readById(id);
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals("Avengers", result.getTrainingName());
    }

    @Test
    void create() {
        Training training = new Training(1L, 1L, 1L, "Avengers", 1L, LocalDateTime.of(2023, 11, 12, 12, 20), 30);
        Mockito.when(trainingErrorValidator.isValidParams(training)).thenReturn(true);
        Mockito.when(trainingDAO.create(training)).thenReturn(training);
        Training result = trainingService.create(training);
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals(30, result.getDuration());
    }

    @Test
    void update() {
        Training existing = new Training(1L, 1L, 1L, "Avengers", 1L, LocalDateTime.of(2023, 11, 12, 12, 20), 30);
        Training updated = new Training(1L, 1L, 1L, "Beginners", 1L, LocalDateTime.of(2023, 11, 12, 9, 00), 30);
        Mockito.when(trainingErrorValidator.isValidParams(updated)).thenReturn(true);
        Mockito.when(trainingDAO.update(updated)).thenReturn(updated);

        Training training = trainingService.update(updated);
        Assertions.assertNotEquals(null, training);
        Assertions.assertEquals("Beginners", training.getTrainingName());
    }

    @Test
    void deleteById() {
        Long id = 2L;
        Mockito.when(trainingDAO.deleteById(id)).thenReturn(true);
        boolean result = trainingService.deleteById(id);
        Mockito.verify(trainingDAO, Mockito.times(1)).deleteById(id);
        Assertions.assertTrue(result);
    }
}
