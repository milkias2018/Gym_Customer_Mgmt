package com.gym.service;


import com.gym.dto.SubscriptionDto;
import com.gym.entity.Subscription;
import com.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
    Subscription AddSubscription(String customerId, SubscriptionDto subscriptionDto) throws CustomerNotFoundException;

    Subscription updateSubscription(String customerId, String subscriptionId, SubscriptionDto subscriptionDto) throws CustomerNotFoundException;

    Subscription getSubscription(String customerId, String subscriptionId) throws CustomerNotFoundException;
}
