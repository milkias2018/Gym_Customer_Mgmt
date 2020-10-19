package develop.dto;

import develop.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

/*    @JsonProperty("id")
    private int id;*/
    @JsonProperty("personNumber")
    private String personNumber;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("registrationDate")
    private String registrationDate;
    @JsonProperty("membershipType")
    private String membershipType;

    public CustomerDto(String personNumber, String firstName, String middleName, String lastName, String registrationDate, String membershipType) {
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.membershipType = membershipType;
    }
    public CustomerDto() {
    }
    public static Customer convertToEntity(CustomerDto customerDto){
        Customer customerEntity=new Customer(customerDto.getPersonNumber(), customerDto.getFirstName(), customerDto.getMiddleName(),
                                             customerDto.getLastName(), customerDto.getRegistrationDate(),
                                             customerDto.getMembershipType());
        return customerEntity;

    }
/*    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

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
