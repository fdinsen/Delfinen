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
        System.out.println("createMember");
        Member member = new Member("Navn", "Telefon", "addresse", "email@email.com", LocalDate.now(), 0, MembershipStatus.PASSIVE, MembershipType.COMPETITIVE);
        MemberMapper instance = new MemberMapper();
        instance.createMember(member);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateMember() {
        System.out.println("updateMember");
        Member member = null;
        MemberMapper instance = new MemberMapper();
        instance.updateMember(member);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMemberByPhone() {
        System.out.println("getMemberByPhone");
        String phone = "";
        MemberMapper instance = new MemberMapper();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.getMemberByPhone(phone);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMemberByName() {
        System.out.println("getMemberByName");
        String name = "";
        MemberMapper instance = new MemberMapper();
        ArrayList<Member> expResult = null;
        ArrayList<Member> result = instance.getMemberByName(name);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
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
