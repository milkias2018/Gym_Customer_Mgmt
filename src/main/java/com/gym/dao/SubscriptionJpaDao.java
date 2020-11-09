package com.gym.dao;

import com.gym.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionJpaDao extends JpaRepository<Subscription, String> {
}
