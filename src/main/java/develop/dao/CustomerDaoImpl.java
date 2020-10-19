
package develop.dao;

import develop.entity.Customer;
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
    public Customer getCustomer(String id) {
        int custId= Integer.parseInt(id);
        Customer customer=entityManager.find(Customer.class,custId);
        return customer;
    }


}

