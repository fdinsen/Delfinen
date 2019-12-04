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
import enums.MembershipStatus;
import enums.MembershipType;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author <Frederik Keis Dinsen>
 */
public class RestanceMapperTest extends TestDataSetup {
    
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
        int expTrainerId = 1;
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
    public void testUserHasRestancePositive() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        
        //Act
        boolean memberHasRestance = instance.memberHasRestance(1);
        
        //Assert
        assertTrue(memberHasRestance);
    }
    
    @Test
    public void testUserHasRestanceNegative() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        
        //Act
        boolean memberHasRestance = instance.memberHasRestance(3);
        
        //Assert
        assertFalse(memberHasRestance);
    }
    
    @Test
    public void testMarkAsPaidOnNonExistentMember() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        
        //Act
        boolean operationSucceeded = instance.markAsPaid(2316161);
        
        //Assert
        assertFalse(operationSucceeded);
    }
    
    @Test
    public void testMarkAsPaidOnDatabase() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        
        //Act
        boolean isMemberPresentBeforeOperation = instance.memberHasRestance(1);
        instance.markAsPaid(1);
        boolean isMemberPresentAfterOperation = instance.memberHasRestance(1);
        
        //Assert
        assertTrue(isMemberPresentBeforeOperation);
        assertFalse(isMemberPresentAfterOperation);
    }
    
    @Test
    public void testMakeNewSeasonBySize() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        instance.markAsPaid(1);
        instance.markAsPaid(2);
        instance.markAsPaid(4);
        int expectedSize = 18;
        int actualSize;
        
        //Act
        instance.makeNewSeason();
        actualSize = instance.getAllRestance().size();
        
        //Assert
        assertEquals(expectedSize, actualSize);
    }
    
    @Test
    public void testMakeNewSeasonByContent() {
        //Arrange
        RestanceMapper instance = new RestanceMapper();
        instance.markAsPaid(1);
        instance.markAsPaid(2);
        instance.markAsPaid(4);
        int expMemberId = 3;
        String expMemberName = "Suzan";
        
        //Act
        instance.makeNewSeason();
        Member actual = instance.getAllRestance().get(2);
        
        //Assert
        assertEquals(expMemberId, actual.getMemberId());
        assertEquals(expMemberName, actual.getName());
    }
    
}
