package develop.gym.service;

import develop.gym.entity.Customer;
import develop.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomerById(UUID customerId) throws CustomerNotFoundException;

    Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException;

    void removeCustomer(UUID customerId) throws CustomerNotFoundException;

    void update(UUID id, Customer customer) throws CustomerNotFoundException;

    List<Customer> getCustomers() throws CustomerNotFoundException;
}

