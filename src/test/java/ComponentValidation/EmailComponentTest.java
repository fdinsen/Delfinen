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
public class EmailComponentTest {
    
    public EmailComponentTest() {
    }

    /**
     * Test of checkComponent method, of class EmailComponent.
     */
    @Test
    public void testEmailNormal() {
        String email = "simon.588.jorgensen@gmail.com";
        EmailComponent instance = new EmailComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(email);
        assertEquals(expResult, result);
    }
    @Test
    public void testEmailNoA() {
        String email = "Abc.example.com";
        EmailComponent instance = new EmailComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(email);
        assertEquals(expResult, result);
    }
    @Test
    public void testEmailTooManyA() {
        String email = "A@b@c@example.com";
        EmailComponent instance = new EmailComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(email);
        assertEquals(expResult, result);
    }
    @Test
    public void testEmailTooManyDots() {
        String email = "john.doe@example..com";
        EmailComponent instance = new EmailComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(email);
        assertEquals(expResult, result);
    }
    
}
