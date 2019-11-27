package model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Member {

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

    public Member(int memberID, String memberName, String phoneNumber, String adresse, String email, LocalDate birthDate, int trainerId, MembershipStatus membershipStatus, MembershipType membershipType) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.adresse = adresse;
        this.email = email;
        this.birthDate = birthDate;
        this.trainerId = trainerId;
        this.membershipStatus = membershipStatus;
        this.membershipType = membershipType;
        
        if(calculateAge() < 18){
            this.teamType = teamType.JUNIOR;
        }else{
            this.teamType = teamType.SENIOR;
        }
        
        calculateSubscription();
    }
    
    public Member(String memberName, String phoneNumber, String adresse, String email, LocalDate birthDate, int trainerId, MembershipStatus membershipStatus, MembershipType membershipType) {
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
        this.adresse = adresse;
        this.email = email;
        this.birthDate = birthDate;
        this.trainerId = trainerId;
        this.membershipStatus = membershipStatus;
        this.membershipType = membershipType;
        
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
            subscription = 500.0;
        } else {
            if (years < 18) {
                subscription = 1000.0;
            } else if (years < 60) {
                subscription = 1600.0;
            } else {
                subscription = 1600.0 * 0.75;
            }
        }
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
}
