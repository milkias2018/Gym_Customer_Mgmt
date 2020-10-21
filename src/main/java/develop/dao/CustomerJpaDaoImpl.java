package develop.dao;

import develop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerJpaDaoImpl {

    @Autowired
    CustomerJpaDao customerJpaDao;

    public Customer createCustomer(Customer customer) {
        return customerJpaDao.saveAndFlush(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerJpaDao.delete(customer);
    }
}
