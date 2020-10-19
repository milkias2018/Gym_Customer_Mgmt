package develop.service;

import develop.dao.CustomerDao;
import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

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
}
