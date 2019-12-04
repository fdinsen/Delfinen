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
public class PhoneComponentTest {
    
    public PhoneComponentTest() {
    }

    /**
     * Test of checkComponent method, of class PhoneComponent.
     */
    @Test
    public void testPhoneComponent() {
        String phone = "12345678";
        PhoneComponent instance = new PhoneComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(phone);
        assertEquals(expResult, result);
    }
    @Test
    public void testPhoneTooLOng() {
        String phone = "1234567811";
        PhoneComponent instance = new PhoneComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(phone);
        assertEquals(expResult, result);
    }
    @Test
    public void testPhoneTooShort() {
        String phone = "1111";
        PhoneComponent instance = new PhoneComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(phone);
        assertEquals(expResult, result);
    }
    @Test
    public void testWrongType() {
        String phone = "asbsd";
        PhoneComponent instance = new PhoneComponent();
        boolean expResult = false;
        boolean result = instance.checkComponent(phone);
        assertEquals(expResult, result);
    }
    
    
}
