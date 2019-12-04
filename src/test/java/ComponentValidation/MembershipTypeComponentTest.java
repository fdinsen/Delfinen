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
public class MembershipTypeComponentTest {
    
    public MembershipTypeComponentTest() {
    }

    /**
     * Test of checkComponent method, of class MembershipTypeComponent.
     */
    @Test
    public void testMembershipType() {
        String idOfType = "1";
        String idOfType2 = "2";
        MembershipTypeComponent instance = new MembershipTypeComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(idOfType);
        boolean result2 = instance.checkComponent(idOfType2);
        assertEquals(expResult, result);
        assertEquals(expResult, result2);
    }
    @Test
    public void testOutOfBounds() {
        String idOfType = "-1";
        String idOfType3 = "3";
        String idOfType2 = "20";
        MembershipTypeComponent instance = new MembershipTypeComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(idOfType);
        boolean result2 = instance.checkComponent(idOfType2);
        boolean result3 = instance.checkComponent(idOfType3);
        assertEquals(expResult, result);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
    }
    
}
