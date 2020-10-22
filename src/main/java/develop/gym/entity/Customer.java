package develop.gym.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
//@SequenceGenerator(name = "seqId", initialValue = 1, allocationSize = 10000)
public class Customer implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqId")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;

    @Column(name = "PERSON_NUMBER")
    private String personNumber;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @OneToOne
    private Address address;
    @OneToOne
    private Membership membership;
    @Column(name = "NUMBER_OF_BOOKINGS_PER_WEEK")
    private int numberOfBookingAllowedPerWeek;
    @Column(name = "MEMBER_SINCE")
    private String memberSince;

    public Customer() {
    }

    public Customer(String id, String personNumber, String firstName, String middleName, String lastName, String phoneNumber, Address address, Membership membership, int numberOfBookingAllowedPerWeek, String memberSince) {
        this.id = id;
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.membership = membership;
        this.numberOfBookingAllowedPerWeek = numberOfBookingAllowedPerWeek;
        this.memberSince = memberSince;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public int getNumberOfBookingAllowedPerWeek() {
        return numberOfBookingAllowedPerWeek;
    }

    public void setNumberOfBookingAllowedPerWeek(int numberOfBookingAllowedPerWeek) {
        this.numberOfBookingAllowedPerWeek = numberOfBookingAllowedPerWeek;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }
}