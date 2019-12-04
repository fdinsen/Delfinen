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
public class IntInputComponentTest {
    
    public IntInputComponentTest() {
    }

    /**
     * Test of checkComponent method, of class IntInputComponent.
     */
    @Test
    public void testIntWithString() {
        String input = "ABC";
        IntInputComponent instance = new IntInputComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testIntWithInts() {
        String input = "1234";
        IntInputComponent instance = new IntInputComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(input);
        assertEquals(expResult, result);
    }
    @Test
    public void testIntWithTooManyInts() {
        String input = "2147483647112121";
        IntInputComponent instance = new IntInputComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(input);
        assertEquals(expResult, result);
    }
    
}
