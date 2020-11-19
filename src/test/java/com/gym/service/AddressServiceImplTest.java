package com.gym.service;

import com.gym.dto.AddressDto;
import com.gym.entity.Address;
import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceImplTest {

    @Autowired
    AddressService addressService;

    @Autowired
    CustomerService customerService;

    @Test
    @Transactional
    public void saveAddress() throws CustomerNotFoundException {

        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setLastName("Test 02");
        customer.setPersonNumber("19840506-1274");
        customerService.saveCustomer(customer);

        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName("Exempelgatan");
        addressDto.setStreetNumber(3);
        addressDto.setCity("Stockholm");

        Address address = addressService.saveAddress(customer.getId(), addressDto);
        assertEquals("Exempelgatan", address.getStreetName());
    }

    @Test
    @Transactional
    public void updateAddress() throws CustomerNotFoundException {

        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setLastName("Test 02");
        customer.setPersonNumber("19840506-1274");

        Address address = new Address();
        address.setStreetName("Street name");
        address.setStreetNumber(5);

        customer.setAddress(address);
        customerService.saveCustomer(customer);

        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName("Exempelgatan");
        addressDto.setStreetNumber(3);

        addressService.updateAddress(customer.getId(), address.getId(), addressDto);

        assertEquals("Exempelgatan", customer.getAddress().getStreetName());
        assertEquals(3, customer.getAddress().getStreetNumber());

    }

    @Test
    @Transactional
    public void getAddressForCustomer() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setLastName("Test 02");
        customer.setPersonNumber("19840506-1274");

        Address address = new Address();
        address.setStreetName("Exempelgatan");
        address.setStreetNumber(5);
        customer.setAddress(address);
        customerService.saveCustomer(customer);

        Address address1 = addressService.getAddressForCustomer(customer.getId(), address.getId());
        assertEquals(address.getStreetName(), address1.getStreetName());
    }
}