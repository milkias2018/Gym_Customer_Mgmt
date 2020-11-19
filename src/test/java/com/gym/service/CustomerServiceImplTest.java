package com.gym.service;

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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @Transactional
    public void saveCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");

        customerService.saveCustomer(customer);
        assertNotNull(customer.getId());
    }

    @Test(expected = NullPointerException.class)
    @Transactional
    public void testSaveNewCustomerThrowsNPE() throws CustomerNotFoundException {

        Customer customer = null;
        customer.setFirstName("aa");
        customerService.saveCustomer(customer);

    }

    @Test
    @Transactional
    public void getCustomerById() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customerService.saveCustomer(customer);
        Customer customer2 = customerService.getCustomerById(customer.getId());
        assertEquals(customer.getId(), customer2.getId());
    }

    @Transactional
    @Test(expected = CustomerNotFoundException.class)
    public void getCustomerByIdThrowsException() throws CustomerNotFoundException {
        Customer customer = customerService.getCustomerById(null);
    }

    @Test
    @Transactional
    public void getCustomerByPersonNummer() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customer.setPersonNumber("12345678-9012");
        customerService.saveCustomer(customer);
        Customer customer2 = customerService.getCustomerByPersonNummer(customer.getPersonNumber());
        assertEquals(customer.getPersonNumber(), customer2.getPersonNumber());
    }

    @Transactional
    @Test(expected = CustomerNotFoundException.class)
    public void getCustomerByPersonNumberThrowsException() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customer.setPersonNumber("12345678-9012");
        customerService.saveCustomer(customer);
        Customer customer2 = customerService.getCustomerByPersonNummer("1211112");
    }

    @Transactional
    @Test
    public void getCustomerByPersonNumberThrowsNPE() throws CustomerNotFoundException {
        Customer customer = customerService.getCustomerByPersonNummer(null);
        assertNull(customer);

    }

    @Transactional
    @Test(expected = CustomerNotFoundException.class)
    public void removeCustomer() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customerService.saveCustomer(customer);
        customerService.removeCustomer(customer.getId());
        Customer customer2 = customerService.getCustomerById(customer.getId());
    }

    @Transactional
    @Test(expected = CustomerNotFoundException.class)
    public void removeCustomerThrowsException() throws CustomerNotFoundException {

        customerService.removeCustomer(null);

    }

    @Test
    @Transactional
    public void update() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customerService.saveCustomer(customer);
        customer.setFirstName("john test 01");
        customerService.update(customer.getId(), customer);
        assertEquals("john test 01", customer.getFirstName());
    }

    @Test(expected = CustomerNotFoundException.class)
    @Transactional
    public void updateThrowsException() throws CustomerNotFoundException {

        Customer customer = new Customer();
        customerService.update(null, customer);
    }

    @Test
    @Transactional
    public void getCustomers() throws CustomerNotFoundException {
        ArrayList<Customer> customerList = new ArrayList<>();

        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setMiddleName("Test 02");
        customer.setLastName("Test 03");
        customerService.saveCustomer(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("john 01");
        customer1.setMiddleName("john 02");
        customer1.setLastName("john 03");
        customerService.saveCustomer(customer1);

        customerList.add(customer);
        customerList.add(customer1);

        List<Customer> getCustomerList = customerService.getCustomers();
        assertEquals(3, getCustomerList.size()); //additional customer added from commandline runner.
        assertEquals("Test 02", getCustomerList.get(1).getMiddleName());
    }

}