package com.gym.service;

import com.gym.dto.SubscriptionDto;
import com.gym.entity.Customer;
import com.gym.entity.Subscription;
import com.gym.exception.CustomerNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubsciptionServiceImplTest {

    @Autowired
    SubscriptionService subscriptionService;
    @Autowired
    CustomerService customerService;

    @Test
    @Transactional
    public void addSubscription() throws CustomerNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName("Test 01");
        customer.setLastName("Test 03");
        customerService.saveCustomer(customer);

        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setSubscriptionType("Monthly");
        subscriptionDto.setSubscriptionPeriod("6 manad");
        subscriptionDto.setCostPerMonth(370);
        Subscription subscription = subscriptionService.AddSubscription(customer.getId(), subscriptionDto);

        assertEquals("6 manad", subscription.getSubscriptionPeriod());

    }

    /*@Test
    void updateSubscription() {
    }

    @Test
    void getSubscription() {
    }*/
}