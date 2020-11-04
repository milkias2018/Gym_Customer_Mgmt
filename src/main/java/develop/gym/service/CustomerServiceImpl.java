package develop.gym.service;

import develop.gym.dao.CustomerDao;
import develop.gym.entity.Customer;
import develop.gym.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
        if (personNummer != null || !personNummer.isEmpty()) {
            return customerDao.getCustomerByPersonNummer(personNummer);
        } else
            throw new CustomerNotFoundException("customer not found");
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
            /*customers.stream()
                    .filter(s -> s.getId() > 1)
                    .map(s -> s.getFirstName().toUpperCase())
                    .sorted(Comparator.naturalOrder());*/
            return customers;
        } else
            throw new CustomerNotFoundException("customer not found");
    }
}
