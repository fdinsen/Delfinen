/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class PrivilegeMapperTest extends TestDataSetup {
    
    public PrivilegeMapperTest() throws IOException{
    }

    /**
     * Test of getPrivileges method, of class PrivilegeMapper.
     */
    @Test
    public void testGetPrivileges() {
        //Arrange
        PrivilegeMapper instance = new PrivilegeMapper();
        boolean[] expected = {false, true, false, false, false,
        false,false, true, true, true, true, true, true, true, true, false};
        boolean[] actual;
        
        //Act
        actual = instance.getPrivileges(2);
        
        //Assert
        assertArrayEquals(expected, actual);
    }
    
}
