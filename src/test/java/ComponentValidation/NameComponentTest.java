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
public class NameComponentTest {
    
    public NameComponentTest() {
    }

    /**
     * Test of checkComponent method, of class NameComponent.
     */
    @Test
    public void testNameComponent() {
        String name = "Simon Jorgensen";
        String name1 = "Simon";
        String name2 = "Simon kjems Jorgensen";
        NameComponent instance = new NameComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(name);
        boolean result1 = instance.checkComponent(name1);
        boolean result2 = instance.checkComponent(name2);
        assertEquals(expResult, result);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
    }
    @Test
    public void testOutOfBounds() {
        String name = "simon 1234";
        String name1 = "Simon#";
        String name2 = "(Simon)";
        NameComponent instance = new NameComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(name);
        boolean result1 = instance.checkComponent(name1);
        boolean result2 = instance.checkComponent(name2);
        assertEquals(expResult, result);
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
    }
}
