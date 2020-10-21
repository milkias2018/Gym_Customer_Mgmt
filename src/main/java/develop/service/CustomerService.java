
package develop.service;

import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomerById(int customerId) throws CustomerNotFoundException;

    Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException;

    void removeCustomer(int customerId) throws CustomerNotFoundException;

    void update(int id, Customer customer) throws CustomerNotFoundException;

    List<Customer> getCustomers() throws CustomerNotFoundException;
}

