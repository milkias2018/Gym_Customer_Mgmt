package com.gym.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gym.entity.Customer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

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
    @JsonProperty("numberOfBookingAllowedPerWeek")
    private int numberOfBookingAllowedPerWeek;
    @JsonProperty("memberSince")
    private String memberSince;

    public CustomerDto(String personNumber, String firstName, String middleName, String lastName, String phoneNumber, int numberOfBookingAllowedPerWeek, String memberSince) {
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.numberOfBookingAllowedPerWeek = numberOfBookingAllowedPerWeek;
        this.memberSince = memberSince;
    }

    public CustomerDto() {
    }

    public static Customer convertToEntity(CustomerDto customerDto) {
        if (customerDto != null) {
            Customer customerEntity = new Customer(customerDto.getPersonNumber(),
                    customerDto.getFirstName(),
                    customerDto.getMiddleName(),
                    customerDto.getLastName(),
                    customerDto.getPhoneNumber(),
                    customerDto.getNumberOfBookingAllowedPerWeek(),
                    customerDto.getMemberSince());
            return customerEntity;
        }
        return null;

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
