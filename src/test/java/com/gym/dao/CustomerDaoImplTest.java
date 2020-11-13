package com.gym.dao;

import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
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
        assertNotNull(customer);
    }

    @Test
    @Transactional
    public void getCustomer() throws CustomerNotFoundException {

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
        assertEquals("1234567890", otherCustomer.getPersonNumber());
    }

    @Test(expected = CustomerNotFoundException.class)
    @Transactional
    public void getCustomerByIdThrowsCustomerNotFoundException() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("TestFirstNamn");
        customer.setMiddleName("TestMiddleNamn");
        customer.setLastName("TestLastNamn");

        customerDao.save(customer);
        customerDao.getCustomer("37467-dff-33-df-df");

    }

    @Test
    @Transactional
    public void getCustomerByPersonNummer() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test01");
        customer.setMiddleName("Test02");
        customer.setLastName("Test03");
        customer.setPersonNumber("1234567890");
        customerDao.save(customer);
        Customer customer1 = customerDao.getCustomerByPersonNummer(customer.getPersonNumber());
        assertEquals("1234567890", customer1.getPersonNumber());
    }

    @Test(expected = CustomerNotFoundException.class)
    @Transactional
    public void removeCustomer() throws CustomerNotFoundException {
        Customer customer = new Customer();

        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customerDao.save(customer);

        customerDao.removeCustomer(customer.getId());
        customerDao.getCustomer(customer.getId());

    }

    @Test(expected = CustomerNotFoundException.class)
    @Transactional
    public void removeCustomerThrowsException() throws CustomerNotFoundException {
        Customer customer = new Customer();

        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customerDao.save(customer);

        customerDao.removeCustomer("sdfg-5476-duj-552");
    }

    @Test
    @Transactional
    public void update() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customerDao.save(customer);

        customer.setFirstName("updated test 01");
        customerDao.update(customer.getId(), customer);

        assertEquals("updated test 01", customer.getFirstName());

    }


    @Test
    @Transactional
    public void getCustomers() {
        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstName("cust 01");
        customer.setMiddleName("cust 02");
        customer.setLastName("cust 03");
        customerDao.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("other cust1");
        customer1.setMiddleName("other cust2");
        customer1.setLastName("other cust3");
        customerDao.save(customer1);

        customers.add(customer);
        customers.add(customer1);
        List<Customer> customerList = customerDao.getCustomers();
        assertEquals(2, customerList.size());
    }
}