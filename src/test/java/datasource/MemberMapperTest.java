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
 * @author olvvang
 */
public class MemberMapperTest extends TestBaseIntegration {

    public MemberMapperTest() throws IOException {
    }
    
    
    
    @Test
    public void testCreateMember() {
        LocalDate dato = LocalDate.now();
        Member member = new Member("navn", "555111", "addresse", "email@email.com", dato, 0, MembershipStatus.PASSIVE, MembershipType.COMPETITIVE);
        MemberMapper instanceMemberMapper = new MemberMapper();
        instanceMemberMapper.createMember(member);
        ArrayList<Member> actual = instanceMemberMapper.getMemberByPhone("555111");
        
        assertEquals("navn", actual.get(0).getName());
        assertEquals("555111", actual.get(0).getPhone());
        assertEquals("addresse", actual.get(0).getAddress());
        assertEquals("email@email.com", actual.get(0).getEmail());
        assertEquals(dato, actual.get(0).getBirthday());
        assertEquals(MembershipStatus.PASSIVE, actual.get(0).getMembershipStatus());
        assertEquals(MembershipType.COMPETITIVE, actual.get(0).getMembershipType());
    }
    
    @Test
    public void testCreateTwoMember() {
        LocalDate dato = LocalDate.now();
        Member member1 = new Member("navn", "555111", "addresse", "email@email.com", dato, 0, MembershipStatus.PASSIVE, MembershipType.COMPETITIVE);
        
        LocalDate dato1 = LocalDate.now();
        Member member2 = new Member("navnet", "55511155", "addresseJA", "email@email.com.com", dato1, 1, MembershipStatus.ACTIVE, MembershipType.CASUAL);
        
        MemberMapper instanceMemberMapper = new MemberMapper();
        instanceMemberMapper.createMember(member1);
        instanceMemberMapper.createMember(member2);
        ArrayList<Member> actual = instanceMemberMapper.getMemberByPhone("555111");
        
        //Member1
        assertEquals("navn", actual.get(0).getName());
        assertEquals("555111", actual.get(0).getPhone());
        assertEquals("addresse", actual.get(0).getAddress());
        assertEquals("email@email.com", actual.get(0).getEmail());
        assertEquals(dato, actual.get(0).getBirthday());
        assertEquals(MembershipStatus.PASSIVE, actual.get(0).getMembershipStatus());
        assertEquals(MembershipType.COMPETITIVE, actual.get(0).getMembershipType());
        
        actual = instanceMemberMapper.getMemberByPhone("55511155");
        
        //Member2
        assertEquals("navnet", actual.get(0).getName());
        assertEquals("55511155", actual.get(0).getPhone());
        assertEquals("addresseJA", actual.get(0).getAddress());
        assertEquals("email@email.com.com", actual.get(0).getEmail());
        assertEquals(dato, actual.get(0).getBirthday());
        assertEquals(MembershipStatus.ACTIVE, actual.get(0).getMembershipStatus());
        assertEquals(MembershipType.CASUAL, actual.get(0).getMembershipType());
    }
    
    

    
    public void testUpdateMember() {
        System.out.println("updateMember");
        Member member = null;
        MemberMapper instance = new MemberMapper();
        instance.updateMember(member);
        fail("The test case is a prototype.");
    }

    
    public void testGetMemberByPhone() {
        System.out.println("getMemberByPhone");
        String phone = "";
        MemberMapper instance = new MemberMapper();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.getMemberByPhone(phone);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
    public void testGetMemberByName() {
        System.out.println("getMemberByName");
        String name = "";
        MemberMapper instance = new MemberMapper();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.getMemberByName(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
    public void testGetMemberByEmail() {
        System.out.println("getMemberByEmail");
        String email = "";
        MemberMapper instance = new MemberMapper();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.getMemberByEmail(email);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
