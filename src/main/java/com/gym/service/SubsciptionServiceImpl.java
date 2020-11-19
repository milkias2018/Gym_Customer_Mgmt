package com.gym.service;

import com.gym.dao.CustomerDao;
import com.gym.dao.SubscriptionJpaDao;
import com.gym.dto.SubscriptionDto;
import com.gym.entity.Customer;
import com.gym.entity.Subscription;
import com.gym.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubsciptionServiceImpl implements SubscriptionService {


    private SubscriptionJpaDao subscriptionJpaDao;
    private CustomerDao customerDao;

    @Autowired
    public SubsciptionServiceImpl(SubscriptionJpaDao subscriptionJpaDao, CustomerDao customerDao) {
        this.subscriptionJpaDao = subscriptionJpaDao;
        this.customerDao = customerDao;
    }

    @Override
    public Subscription AddSubscription(String customerId, SubscriptionDto subscriptionDto) throws CustomerNotFoundException {
        Customer customer = customerDao.getCustomer(customerId);
        if (customer != null) {
            return subscriptionJpaDao.save(SubscriptionDto.convertToEntity(customer, subscriptionDto));
        }
        return null;
    }

    @Override
    public Subscription updateSubscription(String customerId, String subscriptionId, SubscriptionDto subscriptionDto) throws CustomerNotFoundException {

        if (customerId != null && subscriptionId != null && subscriptionDto != null) {
            Customer customer = customerDao.getCustomer(customerId);
            Subscription subscription = subscriptionJpaDao.getOne(subscriptionId);

            if (customer.getMembership().getId().equals(subscription.getId())) {
                subscription.setCostPerMonth(subscriptionDto.getCostPerMonth());
                subscription.setGroupTrainingIncluded(subscriptionDto.isGroupTrainingIncluded());
                subscription.setSubscriptionPeriod(subscriptionDto.getSubscriptionPeriod());
                subscription.setSubscriptionStatus(subscriptionDto.getSubscriptionStatus());
                subscription.setSubscriptionType(subscriptionDto.getSubscriptionType());

                return subscriptionJpaDao.save(subscription);
            }
        }
        return null;
    }

    @Override
    public Subscription getSubscription(String customerId, String subscriptionId) throws CustomerNotFoundException {
        Customer customer = customerDao.getCustomer(customerId);
        Subscription subscription = subscriptionJpaDao.getOne(subscriptionId);

        if (customer.getMembership().getId().equals(subscription.getId()))
            return subscriptionJpaDao.getOne(customer.getMembership().getId());
        else
            throw new NullPointerException();
    }
}
