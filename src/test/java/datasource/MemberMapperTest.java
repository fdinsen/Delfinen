package datasource;

import model.Member;
import enums.MembershipStatus;
import enums.MembershipType;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author olvvang
 */
public class MemberMapperTest extends TestDataSetup {

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

        Member member2 = new Member("navnet", "55511155", "addresseJA", "email@email.com.com", dato, 1, MembershipStatus.ACTIVE, MembershipType.CASUAL);

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

    @Test
    public void testCreateAndGetTwoMembersWithSamePhoneNumber() {
        LocalDate dato = LocalDate.now();
        Member member1 = new Member("navn", "555111", "addresse", "email@email.com", dato, 0, MembershipStatus.PASSIVE, MembershipType.COMPETITIVE);

        Member member2 = new Member("navnet", "555111", "addresseJA", "email@email.com.com", dato, 1, MembershipStatus.ACTIVE, MembershipType.CASUAL);

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

        //Member2
        assertEquals("navnet", actual.get(1).getName());
        assertEquals("555111", actual.get(1).getPhone());
        assertEquals("addresseJA", actual.get(1).getAddress());
        assertEquals("email@email.com.com", actual.get(1).getEmail());
        assertEquals(dato, actual.get(1).getBirthday());
        assertEquals(MembershipStatus.ACTIVE, actual.get(1).getMembershipStatus());
        assertEquals(MembershipType.CASUAL, actual.get(1).getMembershipType());
    }

    @Test
    public void testUpdateMember() {
        String expectedName = "Morten";
        String expectedPhone = "12392712";
        String expectedEmail = "test@testing.com";
        String expectedAddress = "TestVej 5";
        LocalDate expectedBirthday = LocalDate.now();
        MembershipStatus expectedMemberStatus = MembershipStatus.PASSIVE;
        MembershipType expectedMemberType = MembershipType.COMPETITIVE;

        MemberMapper instanceMemberMapper = new MemberMapper();
        ArrayList<Member> memberToChange = instanceMemberMapper.getMemberByPhone("12345678");
        memberToChange.get(0).setName(expectedName);
        memberToChange.get(0).setPhone(expectedPhone);
        memberToChange.get(0).setEmail(expectedEmail);
        memberToChange.get(0).setAddress(expectedAddress);
        memberToChange.get(0).setBirthday(expectedBirthday);
        memberToChange.get(0).setMemberStatus(expectedMemberStatus);
        memberToChange.get(0).setMemberType(expectedMemberType);

        instanceMemberMapper.updateMember(memberToChange.get(0));

        ArrayList<Member> actual = instanceMemberMapper.getMemberByPhone("12392712");
        String actualName = actual.get(0).getName();
        String actualPhone = actual.get(0).getPhone();
        String actualEmail = actual.get(0).getEmail();
        String actualAddress = actual.get(0).getAddress();
        LocalDate actualBirthday = actual.get(0).getBirthday();
        MembershipStatus actualMemberStatus = actual.get(0).getMembershipStatus();
        MembershipType actualMemberType = actual.get(0).getMembershipType();

        //Assert
        assertEquals(expectedName, actualName);
        assertEquals(expectedPhone, actualPhone);
        assertEquals(expectedEmail, actualEmail);
        assertEquals(expectedAddress, actualAddress);
        assertEquals(expectedBirthday, actualBirthday);
        assertEquals(expectedMemberStatus, actualMemberStatus);
        assertEquals(expectedMemberType, actualMemberType);
    }

    @Test
    public void testGetMemberByPhone() {
        MemberMapper instanceMemberMapper = new MemberMapper();
        ArrayList<Member> actual = instanceMemberMapper.getMemberByPhone("12345678");

        assertEquals(1, actual.get(0).getMemberId());
        assertEquals("John", actual.get(0).getName());
        assertEquals("12345678", actual.get(0).getPhone());
        assertEquals("vejvej 1", actual.get(0).getAddress());
        assertEquals("John@gmail.com", actual.get(0).getEmail());
        String str = "1996-05-06";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(str, formatter);
        assertEquals(date, actual.get(0).getBirthday());
        assertEquals(MembershipStatus.ACTIVE, actual.get(0).getMembershipStatus());
        assertEquals(MembershipType.CASUAL, actual.get(0).getMembershipType());
    }

    @Test
    public void testGetMemberByName() {
        MemberMapper instanceMemberMapper = new MemberMapper();
        ArrayList<Member> actual = instanceMemberMapper.getMemberByName("Simon");

        assertEquals(2, actual.get(0).getMemberId());
        assertEquals("Simon", actual.get(0).getName());
        assertEquals("23456789", actual.get(0).getPhone());
        assertEquals("vejvej 2", actual.get(0).getAddress());
        assertEquals("Simon@gmail.com", actual.get(0).getEmail());
        String str = "2005-05-06";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(str, formatter);
        assertEquals(date, actual.get(0).getBirthday());
        assertEquals(MembershipStatus.ACTIVE, actual.get(0).getMembershipStatus());
        assertEquals(MembershipType.COMPETITIVE, actual.get(0).getMembershipType());
    }

    @Test
    public void testGetMemberByEmail() {
        MemberMapper instanceMemberMapper = new MemberMapper();
        ArrayList<Member> actual = instanceMemberMapper.getMemberByEmail("SUzan@gmail.com");

        assertEquals(3, actual.get(0).getMemberId());
        assertEquals("Suzan", actual.get(0).getName());
        assertEquals("34567890", actual.get(0).getPhone());
        assertEquals("Veeeej 1", actual.get(0).getAddress());
        assertEquals("SUzan@gmail.com", actual.get(0).getEmail());
        String str = "1940-05-06";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(str, formatter);
        assertEquals(date, actual.get(0).getBirthday());
        assertEquals(MembershipStatus.ACTIVE, actual.get(0).getMembershipStatus());
        assertEquals(MembershipType.COMPETITIVE, actual.get(0).getMembershipType());
    }

    @Test
    public void testDeleteMember() {
        MemberMapper instanceMemberMapper = new MemberMapper();

        instanceMemberMapper.deleteMember(1);
        int exspected = 0;

        int actual = instanceMemberMapper.getMemberByName("John").size();

        assertEquals(exspected, actual);
    }
}
