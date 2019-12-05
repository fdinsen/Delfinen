/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gamma
 */
public class TimesTest {
    
    public TimesTest() {
    }

    /**
     * Test of getTimeInMS method, of class Times.
     */
    @Test
    public void testConvertToMSOn33min() {
        //Arrange
        String input = "33:33:333";
        int expected = 2013333;
        int actual;
        
        //Act
        actual = Times.convertToMS(input);
        
        //Assert
        assertEquals(expected, actual);
    }
    
    @Test
    public void testConvertToMS() {
        //Arrange
        String input = "33:aa";
        int expected = -1;
        int actual;
        
        //Act
        actual = Times.convertToMS(input);
        
        //Assert
        assertEquals(expected, actual);
    }
}
