/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enums.MembershipStatus;
import enums.MembershipType;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class MemberTest {
    LocalDate birthday = null;
    
    public MemberTest() {
    }
    
    
    /**
     * Test of getSubscription method, of class Member.
     */
    @Test
    public void testGetPassiveSub() {
        birthday = LocalDate.of(1996,1,20);
        ArrayList<String> member1Disciplines = new ArrayList();
        member1Disciplines.add("CRAWL");
        member1Disciplines.add("BUTTERFLY");
        Member john = new Member(0, "John", "1234", "Vejvej 1", 
                "1@1", birthday, 0, MembershipStatus.PASSIVE, 
                MembershipType.COMPETITIVE, member1Disciplines);
        double expResult = 500.0;
        double result = john.getSubscription();
        assertEquals(expResult, result, 0.0);
        
    }
    @Test
    public void testGetActiveUnder18Sub(){
        birthday = LocalDate.of(2005, 1, 20);
        ArrayList<String> member1Disciplines = new ArrayList();
        member1Disciplines.add("CRAWL");
        member1Disciplines.add("BUTTERFLY");
        Member john = new Member(0, "John", "1234", "Vejvej 1", 
                "1@1", birthday, 0, MembershipStatus.ACTIVE, 
                MembershipType.COMPETITIVE, member1Disciplines);
        double expResult = 1000.0;
        double result = john.getSubscription();
        assertEquals(expResult, result, 0.0);
        
    }
    @Test
    public void testGetActiveAbove18Sub(){
        birthday = LocalDate.of(1996, 1, 20);
        ArrayList<String> member1Disciplines = new ArrayList();
        member1Disciplines.add("CRAWL");
        member1Disciplines.add("BUTTERFLY");
        Member john = new Member(0, "John", "1234", "Vejvej 1", 
                "1@1", birthday, 0, MembershipStatus.ACTIVE, 
                MembershipType.COMPETITIVE, member1Disciplines);
        double expResult = 1600.0;
        double result = john.getSubscription();
        assertEquals(expResult, result, 0.0);   
    }
    @Test
    public void testAGetActiveAbove60Sub(){
        birthday = LocalDate.of(1950,1,20);
        ArrayList<String> member1Disciplines = new ArrayList();
        member1Disciplines.add("CRAWL");
        member1Disciplines.add("BUTTERFLY");
        Member john = new Member(0, "John", "1234", "Vejvej 1", 
                "1@1", birthday, 0, MembershipStatus.ACTIVE, 
                MembershipType.COMPETITIVE, member1Disciplines);
        double expResult = 1200.0;
        double result = john.getSubscription();
        assertEquals(expResult, result, 0.0);
        
    }
    
    
}
