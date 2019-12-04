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
public class StringComponentTest {
    
    public StringComponentTest() {
    }

    /**
     * Test of checkComponent method, of class StringComponent.
     */
    @Test
    public void testStringOneSA() {
        String string = "iefbgfibgifgbd@sdjfsdipfb";
        StringComponent instance = new StringComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(string);
        assertEquals(expResult, result);
    }
    @Test
    public void testStringWithWhitespace() {
        String string = "iefbgf ibgifgbd@sdjfsdipfb";
        StringComponent instance = new StringComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(string);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckComponent() {
        String string = "sasd@@sdjfsdipfb";
        StringComponent instance = new StringComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(string);
        assertEquals(expResult, result);
    }
    
}
