package develop.dao;


import develop.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CustomerDao  {

  void save(Customer customer);
  Customer getCustomer(String id);

}
