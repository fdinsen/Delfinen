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
public class BirthdayComponentTest {
    
    public BirthdayComponentTest() {
    }

    /**
     * Test of checkComponent method, of class BirthdayComponent.
     */
    @Test
    public void testBirhtdayComponent() {
        String birthday = "05/06/1996";
        BirthdayComponent instance = new BirthdayComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(birthday);
        assertEquals(expResult, result);
    }
    @Test
    public void testBirhtdayOffDay() {
        String birthday = "5/06/1996";
        BirthdayComponent instance = new BirthdayComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(birthday);
        assertEquals(expResult, result);
    }
    @Test
    public void testBirhtdayLongOff() {
        String birthday = "5/06/96";
        BirthdayComponent instance = new BirthdayComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(birthday);
        assertEquals(expResult, result);
    }
    
}
