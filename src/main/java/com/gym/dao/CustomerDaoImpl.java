
package com.gym.dao;

import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer getCustomer(String customerId) throws CustomerNotFoundException {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer != null)
            return customer;
        else
            throw new CustomerNotFoundException("Customer not found");
    }

    @Override
    public Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException {
        Query customerQuery = entityManager.createQuery("select c from Customer c where c.personNumber LIKE :personNummer").
                setParameter("personNummer", personNummer);
        if (customerQuery != null)
            return (Customer) customerQuery.getSingleResult();
        else
            throw new CustomerNotFoundException("Customer not found");
    }

    @Override
    public void removeCustomer(String customerId) throws CustomerNotFoundException {
        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer != null)
            entityManager.remove(customer);
        else
            throw new CustomerNotFoundException("customer not found");

    }

    @Override
    public void update(String id, Customer customer) throws CustomerNotFoundException {
        Customer customerToUpdate = entityManager.find(Customer.class, id);
        if (customerToUpdate != null) {
            customerToUpdate.setPersonNumber(customer.getPersonNumber());
            customerToUpdate.setFirstName(customer.getFirstName());
            customerToUpdate.setMiddleName(customer.getMiddleName());
            customerToUpdate.setLastName(customer.getLastName());
            //customerToUpdate.setMembershipType(customer.getMembershipType());
            //customerToUpdate.setRegistrationDate(customer.getRegistrationDate());
        } else
            throw new CustomerNotFoundException("customer not found");
    }

    @Override
    public List<Customer> getCustomers() {
        Query customersQuery = entityManager.createQuery("select c from Customer c");
        return customersQuery.getResultList();
    }
}

