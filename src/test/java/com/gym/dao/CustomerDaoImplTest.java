package com.gym.dao;

import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class CustomerDaoImplTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    @Transactional
    public void testSaveNewCustomer() throws CustomerNotFoundException {

        Customer customer = new Customer();

        customer.setFirstName("TestFirstNamn");
        customer.setMiddleName("TestMiddleNamn");
        customer.setLastName("TestLastNamn");
        customer.setPersonNumber("1234567890");
        customer.setPhoneNumber("0751211232");
        customer.setNumberOfBookingAllowedPerWeek(5);
        customer.setMemberSince("2018-02-02");

        customerDao.save(customer);
        Customer otherCustomer = customerDao.getCustomer(customer.getId());

        assertEquals(otherCustomer.getFirstName(), customer.getFirstName());
    }

    /*@Test
    void getCustomer() {
    }

    @Test
    void getCustomerByPersonNummer() {
    }

    @Test
    void removeCustomer() {
    }

    @Test
    void update() {
    }

    @Test
    void getCustomers() {
    }*/
}