package develop.gym.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import develop.gym.entity.Customer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("personNumber")
    private String personNumber;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("phonenumber")
    private String phoneNumber;
    @JsonProperty("address")
    private AddressDto addressDto;
    @JsonProperty("membership")
    private MembershipDto membershipDto;
    @JsonProperty("numberOfBookingAllowedPerWeek")
    private int numberOfBookingAllowedPerWeek;
    @JsonProperty("memberSince")
    private String memberSince;

    public CustomerDto(String id, String personNumber, String firstName, String middleName, String lastName, String phoneNumber, AddressDto addressDto, MembershipDto membershipDto, int numberOfBookingAllowedPerWeek, String memberSince) {
        this.id = id;
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.addressDto = addressDto;
        this.membershipDto = membershipDto;
        this.numberOfBookingAllowedPerWeek = numberOfBookingAllowedPerWeek;
        this.memberSince = memberSince;
    }

    public CustomerDto() {
    }

    public static Customer convertToEntity(CustomerDto customerDto) {
        if (customerDto != null) {
            Customer customerEntity = new Customer(customerDto.getId(), customerDto.getPersonNumber(), customerDto.getFirstName(), customerDto.getMiddleName(),
                    customerDto.getLastName(), customerDto.getPhoneNumber(), AddressDto.convertToEntity(customerDto.addressDto),
                    MembershipDto.convertToEntity(customerDto.getMembershipDto()), customerDto.getNumberOfBookingAllowedPerWeek(),
                    customerDto.getMemberSince());
            return customerEntity;
        }
        return null;

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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public MembershipDto getMembershipDto() {
        return membershipDto;
    }

    public void setMembershipDto(MembershipDto membershipDto) {
        this.membershipDto = membershipDto;
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
