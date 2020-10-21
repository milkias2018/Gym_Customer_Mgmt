package develop.dao;

import develop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaDao extends JpaRepository<Customer, Integer> {
}
