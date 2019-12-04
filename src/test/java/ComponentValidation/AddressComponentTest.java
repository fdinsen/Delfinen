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
public class AddressComponentTest {
    
    public AddressComponentTest() {
    }

    /**
     * Test of checkComponent method, of class AddressComponent.
     */
    @Test
    public void testAdressNormal() {
        String address = "Billeshavevej 75 Korup 5210";
        AddressComponent instance = new AddressComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(address);
        assertEquals(expResult, result);
    }
    @Test
    public void testAdressWithSpace() {
        String address = "Hedevang 41 Overby Lyng 4583";
        AddressComponent instance = new AddressComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(address);
        assertEquals(expResult, result);
    }
    @Test
    public void testAddressWithApparment() {
        String address = "Finlandsvej 6E st 01 Vejle 7100";
        AddressComponent instance = new AddressComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(address);
        assertEquals(expResult, result);
    }
    @Test
    public void testAddressWithAppartmentTwo() {
        String address = "Vestergade 68  3. TH 8900";
        AddressComponent instance = new AddressComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(address);
        assertEquals(expResult, result);
    }
    @Test
    public void testAddressCiyAndPostal() {
        String address = "Buddingevej 260 soborg 2860";
        AddressComponent instance = new AddressComponent();
        boolean expResult = true;
        boolean result = instance.checkComponent(address);
        assertEquals(expResult, result);
    }
    
}
