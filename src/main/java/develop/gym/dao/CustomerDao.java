package develop.gym.dao;


import develop.gym.entity.Customer;
import develop.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomerDao {

    void save(Customer customer);

    Customer getCustomer(String customerId) throws CustomerNotFoundException;

    Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException;

    void removeCustomer(String customerId) throws CustomerNotFoundException;

    void update(String id, Customer customer) throws CustomerNotFoundException;

    List<Customer> getCustomers();

}
