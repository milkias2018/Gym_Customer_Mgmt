package develop.gym.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESSES")
public class Address implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Customer customer;
    @Column(name = "STREET_NAME")
    private String streetName;
    @Column(name = "STREET_NUMBER")
    private int streetNumber;
    @Column(name = "ROOM_NUMBER")
    private int roomNumber;
    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "MUNICIPALITY")
    private String municipality;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;

    public Address(String id, Customer customer, String streetName, int streetNumber, int roomNumber, String zipCode, String municipality, String city, String country) {
        this.id = id;
        this.customer = customer;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.roomNumber = roomNumber;
        this.zipCode = zipCode;
        this.municipality = municipality;
        this.city = city;
        this.country = country;
    }

    public Address() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
