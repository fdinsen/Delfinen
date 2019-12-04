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
public class SwimmingDisciplinesComponentTest {
    
    public SwimmingDisciplinesComponentTest() {
    }

    /**
     * Test of checkComponent method, of class SwimmingDisciplinesComponent.
     */
    @Test
    public void testSwimingDisciplineComponent() {
        String ids = "1234";
        SwimmingDisciplinesComponent instance = new SwimmingDisciplinesComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(ids);
        assertEquals(expResult, result);
    }
    @Test
    public void testRealSwiming() {
        String ids = "1,2,3";
        SwimmingDisciplinesComponent instance = new SwimmingDisciplinesComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(ids);
        assertEquals(expResult, result);
    }
    @Test
    public void testRealSwimingtooLong() {
        String ids = "1,2,3,4,5,6,7,8,9";
        SwimmingDisciplinesComponent instance = new SwimmingDisciplinesComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(ids);
        assertEquals(expResult, result);
    }
    @Test
    public void testRealSwimingShort() {
        String ids = "";
        SwimmingDisciplinesComponent instance = new SwimmingDisciplinesComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(ids);
        assertEquals(expResult, result);
    }
    
}
