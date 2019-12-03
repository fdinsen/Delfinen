package model;

import enums.TeamType;
import enums.MembershipStatus;
import enums.MembershipType;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Member {
    private final double PASSIVE_SUBSCRIPTION = 500.0;
    private final double JUNIOR_SUBSCRIPTION = 1000.0;
    private final double SENIOR_SUBSCRIPTION = 1600.0;
    private final double SENIOR_SUBSCRIPTION_WITHDISCOUNT = 1200.0;
    private int memberID;
    private String memberName;
    private String phoneNumber;
    private String adresse;
    private String email;
    private LocalDate birthDate;
    private int trainerId;
    private MembershipStatus membershipStatus;
    private MembershipType membershipType;
    private double subscription;
    private TeamType teamType;
    private ArrayList<String> disciplines;

    public Member(int memberID, String memberName, String phoneNumber, 
            String adresse, String email, LocalDate birthDate, int trainerId, 
            MembershipStatus membershipStatus, MembershipType membershipType,
            ArrayList<String> disciplines) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.adresse = adresse;
        this.email = email;
        this.birthDate = birthDate;
        this.trainerId = trainerId;
        this.membershipStatus = membershipStatus;
        this.membershipType = membershipType;
        this.disciplines = disciplines;
        
        if(calculateAge() < 18){
            this.teamType = teamType.JUNIOR;
        }else{
            this.teamType = teamType.SENIOR;
        }
        
        calculateSubscription();
    }
    
    public Member(String memberName, String phoneNumber, String adresse, 
            String email, LocalDate birthDate, int trainerId, 
            MembershipStatus membershipStatus, MembershipType membershipType,
            ArrayList<String> disciplines) {
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.adresse = adresse;
        this.email = email;
        this.birthDate = birthDate;
        this.trainerId = trainerId;
        this.membershipStatus = membershipStatus;
        this.membershipType = membershipType;
        this.disciplines = disciplines;
        
        if(calculateAge() < 18){
            this.teamType = teamType.JUNIOR;
        }else{
            this.teamType = teamType.SENIOR;
        }
        
        calculateSubscription();
    }

    private long calculateAge() {
        LocalDate now = LocalDate.now();
        long years = birthDate.until(now, ChronoUnit.YEARS);
        return years;
    }

    private void calculateSubscription() {

        long years = calculateAge();

        if (membershipStatus == membershipStatus.PASSIVE) {
            subscription = PASSIVE_SUBSCRIPTION;
        } else {
            if (years < 18) {
                subscription = JUNIOR_SUBSCRIPTION;
            } else if (years < 60) {
                subscription = SENIOR_SUBSCRIPTION;
            } else {
                subscription = SENIOR_SUBSCRIPTION_WITHDISCOUNT;
            }
        }
    }

    public ArrayList<String> getMemberDisciplines() {
        return disciplines;
    }
    
    public double getSubscription() {
        return subscription;
    }

    public String getName() {
        return memberName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getAddress() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthDate;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public int getMemberId() {
        return memberID;
    }

    public void setName(String name) {
        this.memberName = name;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.adresse = address;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthDate = birthday;
    }

    public void setMemberStatus(MembershipStatus memberStatus) {
        this.membershipStatus = memberStatus;
    }

    public void setMemberType(MembershipType memberType) {
        this.membershipType = memberType;
    }
}
