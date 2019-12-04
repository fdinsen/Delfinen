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
public class MembershipStatusComponentTest {
    
    public MembershipStatusComponentTest() {
    }

    /**
     * Test of checkComponent method, of class MembershipStatusComponent.
     */
    @Test
    public void testMemberShipStatus() {
        String idOfStatus = "1";
        String idOfStatus2 = "2";
        MembershipStatusComponent instance = new MembershipStatusComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(idOfStatus);
        boolean result2 = instance.checkComponent(idOfStatus2);
        assertEquals(expResult, result);
        assertEquals(expResult, result2);
    }
    @Test
    public void testMemebershipStatusOutOfBounds() {
        String idOfStatus = "-1";
        String idOfStatus2 = "20";
        MembershipStatusComponent instance = new MembershipStatusComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(idOfStatus);
        boolean result2 = instance.checkComponent(idOfStatus2);
        assertEquals(expResult, result);
        assertEquals(expResult, result2);
    }
    
}
