package develop.dao;


import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public interface CustomerDao {

    void save(Customer customer);

    Customer getCustomer(UUID customerId) throws CustomerNotFoundException;

    Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException;

    void removeCustomer(UUID customerId) throws CustomerNotFoundException;

    void update(UUID id, Customer customer) throws CustomerNotFoundException;

    List<Customer> getCustomers();

}
