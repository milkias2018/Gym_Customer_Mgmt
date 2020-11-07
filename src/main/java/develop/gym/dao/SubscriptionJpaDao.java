package develop.gym.dao;

import develop.gym.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionJpaDao extends JpaRepository<Subscription, String> {
}
