/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Member;
import model.MembershipStatus;
import model.MembershipType;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class RestanceMapperTest extends TestBaseIntegration {
    
    public RestanceMapperTest() throws IOException {
    }

    /**
     * Test of getAllRestance method, of class RestanceMapper.
     */
    @Test
    public void testGetAllRestanceBySize() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        int expectedSize = 3;
        int actualSize;
        ArrayList<Member> arr;
        
        //Act
        actualSize = instance.getAllRestance().size();
        
        //Assert
        assertEquals(expectedSize, actualSize);
        
        
    }

    @Test
    public void testGetAllRestanceByContent() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        int expMemberId = 1;
        String expMemberName = "John";
        String expPhoneNum = "12345678";
        String expAddress = "vejvej 1";
        String expEmail = "John@gmail.com";
        String expBirthday = "1996-05-06";
        int expTrainerId = 0;
        MembershipStatus expMemStatus = MembershipStatus.ACTIVE;
        MembershipType expMemType = MembershipType.CASUAL;
        
        //Act
        Member actual = instance.getAllRestance().get(0);
        
        //Assert
        assertEquals(expMemberId, actual.getMemberId());
        assertEquals(expMemberName, actual.getName());
        assertEquals(expPhoneNum, actual.getPhone());
        assertEquals(expAddress, actual.getAddress());
        assertEquals(expEmail, actual.getEmail());
        assertEquals(expBirthday, actual.getBirthday().toString());
        assertEquals(expTrainerId, actual.getTrainerId());
        assertEquals(expMemStatus, actual.getMembershipStatus());
        assertEquals(expMemType, actual.getMembershipType());
    }
    
    /**
     * Test of userHasRestance method, of class RestanceMapper.
     */
    @Test
    public void testUserHasRestance() {
        //Arrange
        
        
        //Act
        
        
        //Assert
        fail("test not implemented");
    }
    
}
