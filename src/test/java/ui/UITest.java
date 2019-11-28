/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class UITest {
    
    public UITest() {
    }

    /**
     * Test of checkInputType method, of class UI.
     */
    @Test
    public void testCheckInputTypePhone() {
        //Arrange
        UI instance = new UIImpl();
        int exp = 1;
        int actual;
        
        //Act
        actual = instance.checkInputType("44491881");
                
        //Assert
        assertEquals(exp, actual);
    }
    
    @Test
    public void testCheckInputTypePhoneNegative() {
        //Arrange
        UI instance = new UIImpl();
        int exp = -1;
        int actual;
        
        //Act
        actual = instance.checkInputType("44491881a");
        
        //Assert
        assertEquals(exp, actual);
    }
    
    @Test
    public void testCheckInputTypeEmail() {
        //Arrange
        UI instance = new UIImpl();
        int exp = 0;
        int actual;
        
        //Act
        actual = instance.checkInputType("frederik@gmail.com");
                
        //Assert
        assertEquals(exp, actual);
    }
    
    @Test
    public void testCheckInputTypeEmailNegative() {
        //Arrange
        UI instance = new UIImpl();
        int exp = -1;
        int actual;
        
        //Act
        actual = instance.checkInputType("frederik@@gmail.com");
                
        //Assert
        assertEquals(exp, actual);
    }
    
    @Test
    public void testCheckInputTypeMemberId() {
        //Arrange
        UI instance = new UIImpl();
        int exp = 2;
        int actual;
        
        //Act
        actual = instance.checkInputType("54");
                
        //Assert
        assertEquals(exp, actual);
    }

    public class UIImpl extends UI {
    }
    
}
