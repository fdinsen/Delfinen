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
 * @author gamma
 */
public class TimeComponentTest {
    
    public TimeComponentTest() {
    }

    /**
     * Test of checkComponent method, of class TimeComponent.
     */
    @Test
    public void testCheckComponentPositive() {
        //Arrange
        TimeComponent instance = new TimeComponent();
        String testString = "59:59:999";
        
        //Assert
        assertTrue(instance.checkComponent(testString));
    }
    
    @Test
    public void testCheckComponentNegative() {
        //Arrange
        TimeComponent instance = new TimeComponent();
        String testString = "90:60:999";
        
        //Assert
        assertFalse(instance.checkComponent(testString));
    }
    
    @Test
    public void testCheckComponentWrongSyntax() {
        //Arrange
        TimeComponent instance = new TimeComponent();
        String testString = "59:59:99";
        
        //Assert
        assertFalse(instance.checkComponent(testString));
    }
    
    @Test
    public void testCheckComponentPositiveWrongSeperator() {
        //Arrange
        TimeComponent instance = new TimeComponent();
        String testString = "59.59.999";
        
        //Assert
        assertFalse(instance.checkComponent(testString));
    }
    
}
