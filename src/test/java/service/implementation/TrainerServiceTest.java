package service.implementation;

import dao.implementation.TrainerDAO;
import domain.Trainer;
import domain.Training;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import utils.validation.impl.TrainerErrorValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrainerServiceTest {
    @Mock
    TrainerDAO trainerDAO;
    @Mock
    TrainerErrorValidator trainerErrorValidator;
    @InjectMocks
    TrainerService trainerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void readAll() {
        List<Trainer> trainerList = new ArrayList<>();
        Trainer trainer1 = new Trainer(1L, 1L, 1L);
        Trainer trainer2 = new Trainer(2L, 2L, 3L);
        Trainer trainer3 = new Trainer(3L, 1L, 2L);
        trainerList.add(trainer1);
        trainerList.add(trainer2);
        trainerList.add(trainer3);

        Mockito.when(trainerDAO.readAll()).thenReturn(trainerList);

        List<Trainer> result = trainerService.readAll();

        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void readById() {
        Long id = 2L;
        Trainer trainer = new Trainer(2L, 1L, 4L);
        Mockito.when(trainerDAO.readById(id)).thenReturn(trainer);
        Trainer result = trainerService.readById(id);
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals(1L, result.getSpecialization());
    }

    @Test
    void create() {
        Trainer trainer = new Trainer(1L, 1L, 1L);
        Mockito.when(trainerErrorValidator.isValidParams(trainer)).thenReturn(true);
        Mockito.when(trainerDAO.create(trainer)).thenReturn(trainer);
        Trainer result = trainerService.create(trainer);
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void update() {
        Trainer trainer = new Trainer(2L, 1L, 4L);
        Trainer updated = new Trainer(2L, 2L, 4L);
        Mockito.when(trainerErrorValidator.isValidParams(updated)).thenReturn(true);
        Mockito.when(trainerDAO.update(updated)).thenReturn(updated);

        Trainer result = trainerService.update(updated);
        Assertions.assertNotEquals(null, result);
        Assertions.assertEquals(2L, result.getSpecialization());
    }

    @Test
    void deleteById() {
        Long id = 3L;
        Mockito.when(trainerDAO.deleteById(id)).thenReturn(true);
        boolean result = trainerService.deleteById(id);
        Mockito.verify(trainerDAO, Mockito.times(1)).deleteById(id);
        Assertions.assertTrue(result);
    }
}
