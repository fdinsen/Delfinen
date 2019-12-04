/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import model.Trainer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class TrainerMapperTest extends TestDataSetup {
    
    public TrainerMapperTest() throws IOException {
    }

    
    /**
     * Test of getTrainer method, of class TrainerMapper.
     */
    @Test
    public void testGetTrainer() {
        //Arrange
        TrainerMapper instance = new TrainerMapper();
        String expTrainerName = "TrainerJohn";
        String actualTrainerName;
        
        //Act
        actualTrainerName = instance.getTrainer(2).getTrainerName();
        
        //Assert
        assertEquals(expTrainerName, actualTrainerName);
    }
    
    @Test
    public void testGetTrainerOnNonExistentId() {
        //Arrange
        TrainerMapper instance = new TrainerMapper();

        
        //Act
        Trainer trainer = instance.getTrainer(7);
        
        //Assert
        assertEquals(null, trainer);
    }
    /**
     * Test of createTrainer method, of class TrainerMapper.
     */
    @Test
    public void testCreateTrainer() {
        //Arrange
        TrainerMapper instance = new TrainerMapper();
        String expectedName = "Peter";
        String actualName;
        Trainer newTrainer = new Trainer(expectedName);
        
        //Act
        instance.createTrainer(newTrainer);
        actualName = instance.getTrainer(5).getTrainerName();
        
        //Assert
        assertEquals(expectedName, actualName);
    }

    /**
     * Test of updateTrainer method, of class TrainerMapper.
     */
    @Test
    public void testUpdateTrainer() {
        //Arrange
        TrainerMapper instance = new TrainerMapper();
        String expectedName = "Peter";
        String actualName;
        Trainer trainerToUpdate = new Trainer(expectedName, 2);
        
        //Act
        instance.updateTrainer(trainerToUpdate);
        actualName = instance.getTrainer(2).getTrainerName();
        
        //Assert
        assertEquals(expectedName, actualName);
        
    }

    /**
     * Test of deleteTrainer method, of class TrainerMapper.
     */
    @Test
    public void testDeleteTrainer() {
        //Arrange
        TrainerMapper instance = new TrainerMapper();
        String nameOfTrainerToDelete = "TrainerJohn";
        int idOfTrainerToDelete = 2;
        
        
        //Act
        Trainer trainerToDelete = instance.getTrainer(idOfTrainerToDelete);
        instance.deleteTrainer(idOfTrainerToDelete);
        Trainer deletedTrainer = instance.getTrainer(idOfTrainerToDelete);
        
        //Assert
        assertEquals(nameOfTrainerToDelete, trainerToDelete.getTrainerName());
        assertEquals(null, deletedTrainer);
    }

    @Test
    public void testGetAllTrainersByContent() {
        //Arrange
        TrainerMapper instance = new TrainerMapper();
        String[] expectedTrainers = {"TrainerJohn", "TrainerJoe", "TrainerMagrette"};
        String[] actualTrainers;

        //Act
        actualTrainers = instance.getAllTrainers();
        
        //Assert
        assertArrayEquals(expectedTrainers, actualTrainers);
        
    }
    
    
}
