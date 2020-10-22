package develop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import develop.entity.Address;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    @JsonProperty("id")
    private String id;
    @JsonProperty("streetName")
    private String streetName;
    @JsonProperty("streetNumber")
    private int streetNumber;
    @JsonProperty("roomNumber")
    private int roomNumber;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("municipality")
    private String municipality;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;

    public AddressDto(String id, String streetName, int streetNumber, int roomNumber, String zipCode, String municipality, String city, String country) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.roomNumber = roomNumber;
        this.zipCode = zipCode;
        this.municipality = municipality;
        this.city = city;
        this.country = country;
    }

    public AddressDto() {
    }

    public static Address convertToEntity(AddressDto addressDto) {
        Address address1 = new Address(addressDto.getId().toString(), addressDto.getStreetName(), addressDto.getStreetNumber(),
                addressDto.getRoomNumber(), addressDto.getZipCode(),
                addressDto.getMunicipality(), addressDto.getCity(), addressDto.getCountry());
        return address1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
