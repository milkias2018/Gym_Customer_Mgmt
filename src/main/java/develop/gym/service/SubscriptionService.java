package develop.gym.service;


import develop.gym.dto.SubscriptionDto;
import develop.gym.entity.Subscription;
import develop.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionService {
    Subscription AddSubscription(String customerId, SubscriptionDto subscriptionDto) throws CustomerNotFoundException;

    Subscription updateSubscription(String customerId, SubscriptionDto subscriptionDto) throws CustomerNotFoundException;

    Subscription getSubscription(String customerId) throws CustomerNotFoundException;
}
