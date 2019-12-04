/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentValidation;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class TrainerComponentTest {
    
    public TrainerComponentTest() {
    }

    /**
     * Test of checkComponent method, of class TrainerComponent.
     */
    @Test
    public void testTrainerComponentWrongDataType() {
        String trainerID = "abc";
        TrainerComponent instance = new TrainerComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(trainerID);
        assertEquals(expResult, result);
    }
    @Test
    public void testCorrectDataType() {
        String trainerID = "11234";
        TrainerComponent instance = new TrainerComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(trainerID);
        assertEquals(expResult, result);
    }
    
}
