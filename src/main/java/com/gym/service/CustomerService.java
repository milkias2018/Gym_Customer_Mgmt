package com.gym.service;

import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomerById(String customerId) throws CustomerNotFoundException;

    Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException;

    void removeCustomer(String customerId) throws CustomerNotFoundException;

    void update(String id, Customer customer) throws CustomerNotFoundException;

    List<Customer> getCustomers() throws CustomerNotFoundException;
}

