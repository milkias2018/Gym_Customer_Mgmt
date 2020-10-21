package develop.service;

import develop.dao.CustomerDao;
import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
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
    public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
        if (customerId != 0) {
            return customerDao.getCustomer(customerId);
        } else
            throw new CustomerNotFoundException("customer not found");
    }

    @Override
    public Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException {
        if (personNummer != null) {
            return customerDao.getCustomerByPersonNummer(personNummer);
        } else
            throw new CustomerNotFoundException("customer not found");
    }

    @Override
    public void removeCustomer(int customerId) throws CustomerNotFoundException {
        if (customerId != 0)
            customerDao.removeCustomer(customerId);
        else
            throw new CustomerNotFoundException("customer not found exception");
    }

    @Override
    public void update(int id, Customer customer) throws CustomerNotFoundException {
        if (id != 0 && customer != null) {
            customerDao.update(id, customer);
        } else
            throw new CustomerNotFoundException("customer not found");
    }

    @Override
    public List<Customer> getCustomers() throws CustomerNotFoundException {
        List<Customer> customers = customerDao.getCustomers();
        if (customers != null)
            return customers;
        else
            throw new CustomerNotFoundException("customer not found");
    }
}
