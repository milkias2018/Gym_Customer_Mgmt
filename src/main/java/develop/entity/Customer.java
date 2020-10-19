package develop.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUSTOMER")
@SequenceGenerator(name = "seqId", initialValue = 1, allocationSize = 10000)
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqId")
    @Column(name = "ID")
    private int id;

    @Column(name = "PERSON_NUMBER")
    private String personNumber;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "REGISTRATION_DATE")
    private String registrationDate;
    @Column(name = "MEMBERSHIP_TYPE")
    private String membershipType;

    public Customer() {
    }

    public Customer(String personNumber, String firstName, String middleName, String lastName, String registrationDate, String membershipType) {
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.membershipType = membershipType;
    }

   public int getId() {
        return id;
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
