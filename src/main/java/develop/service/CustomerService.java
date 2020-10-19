
package develop.service;

import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomerById(int customerId) throws CustomerNotFoundException;
}

