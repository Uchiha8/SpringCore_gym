package service.implementation;

import dao.implementation.TraineeDAO;
import domain.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import utils.validation.impl.TraineeErrorValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TraineeServiceTest {
    @Mock
    TraineeDAO traineeDAO;
    @Mock
    TraineeErrorValidator traineeErrorValidator;
    @InjectMocks
    TraineeService traineeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void readAll() {
        List<Trainee> traineeList = new ArrayList<>();
        Trainee trainee1 = new Trainee(1L, LocalDate.of(2003, 11, 13), "New York", 2L);
        Trainee trainee2 = new Trainee(2L, LocalDate.of(2003, 10, 13), "Samarqand", 3L);
        traineeList.add(trainee1);
        traineeList.add(trainee2);
        Mockito.when(traineeDAO.readAll()).thenReturn(traineeList);
        List<Trainee> result = traineeService.readAll();
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void readById() {
        Long id = 2L;
        Trainee trainee1 = new Trainee(1L, LocalDate.of(2003, 11, 13), "New York", 2L);
        Mockito.when(traineeDAO.readById(id)).thenReturn(trainee1);
        Trainee result = traineeService.readById(id);
        Assertions.assertEquals("New York", result.getAddress());
    }

    @Test
    void creat() {
        Trainee trainee = new Trainee(1L, LocalDate.of(2003, 11, 13), "New York", 2L);
        Mockito.when(traineeErrorValidator.isValidParams(trainee)).thenReturn(true);
        Mockito.when(traineeDAO.create(trainee)).thenReturn(trainee);
        Trainee result = traineeService.create(trainee);
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals("New York", result.getAddress());
    }

    @Test
    void update() {
        Trainee existing = new Trainee(1L, LocalDate.of(2003, 11, 13), "New York", 2L);
        Trainee updated = new Trainee(1L, LocalDate.of(2003, 11, 13), "Tashkent", 2L);
        Mockito.when(traineeErrorValidator.isValidParams(updated)).thenReturn(true);
        Mockito.when(traineeDAO.update(updated)).thenReturn(updated);
        Trainee result = traineeService.update(updated);
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals("Tashkent", result.getAddress());
    }

    @Test
    void deleteById() {
        Long id = 3L;
        Mockito.when(traineeDAO.deleteById(id)).thenReturn(true);
        boolean result = traineeService.deleteById(id);
        Mockito.verify(traineeDAO, Mockito.times(1)).deleteById(id);
        Assertions.assertTrue(result);
    }
}
