package develop.dao;


import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerDao  {

  void save(Customer customer);
  Customer getCustomer(int customerId) throws CustomerNotFoundException;
  Customer getCustomerByPersonNummer(String personNummer) throws CustomerNotFoundException;

  void removeCustomer(int customerId) throws CustomerNotFoundException;

}
