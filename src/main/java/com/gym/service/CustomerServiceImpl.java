package com.gym.service;

import com.gym.dao.CustomerDao;
import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer != null) {
            customerDao.save(customer);
        } else
            throw new NullPointerException();
    }

    @Override
    public Customer getCustomerById(String customerId) throws CustomerNotFoundException {
        if (customerId != null) {
            return customerDao.getCustomer(customerId);
        } else
            throw new CustomerNotFoundException("customer not found");
    }

    @Override
    public Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException {
        try {
            if (personNummer != null) {
                return customerDao.getCustomerByPersonNummer(personNummer);
            }
        } catch (CustomerNotFoundException | EmptyResultDataAccessException e) {
            throw new CustomerNotFoundException("Customer not found exception");
        }
        return null;
    }

    @Override
    public void removeCustomer(String customerId) throws CustomerNotFoundException {
        if (customerId != null)
            customerDao.removeCustomer(customerId);
        else
            throw new CustomerNotFoundException("customer not found exception");
    }

    @Override
    public void update(String id, Customer customer) throws CustomerNotFoundException {
        if (id != null && customer != null) {
            customerDao.update(id, customer);
        } else
            throw new CustomerNotFoundException("customer not found");
    }

    @Override
    public List<Customer> getCustomers() throws CustomerNotFoundException {
        List<Customer> customers = customerDao.getCustomers();

        if (customers != null) {
            return customers;
        } else
            throw new CustomerNotFoundException("customer not found");
    }
}
