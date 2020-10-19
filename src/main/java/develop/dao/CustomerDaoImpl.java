
package develop.dao;

import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Customer customer) {
       entityManager.persist(customer);
    }

    @Override
    public Customer getCustomer(int customerId) throws CustomerNotFoundException {

        Customer customer = entityManager.find(Customer.class, customerId);
        if (customer != null)
            return customer;
        else
            throw new CustomerNotFoundException("Customer not found");
    }
}

