package com.gym.controller;

import com.gym.dto.SubscriptionDto;
import com.gym.entity.Subscription;
import com.gym.exception.CustomerNotFoundException;
import com.gym.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class SubscriptionResource extends BaseResource {

    private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);
    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionResource(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping(value = "/customers/{customerId}/subscription",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> AddSubscription(@PathVariable String customerId, @RequestBody SubscriptionDto subscriptionDto) {
        if (customerId != null && subscriptionDto != null) {
            Subscription subscription = null;
            try {
                subscription = subscriptionService.AddSubscription(customerId, subscriptionDto);
                return ResponseEntity.ok(subscription.getId());
            } catch (CustomerNotFoundException e) {
                logger.info(e.getMessage());
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.status(500).build();
    }

    @PutMapping(value = "/customers/{customerId}/subscriptions/{subscriptionId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> updateSubscription(@PathVariable String customerId, @PathVariable String subscriptionId, @RequestBody SubscriptionDto subscriptionDto) {

        if (customerId != null && subscriptionDto != null) {
            Subscription subscription = null;
            try {
                subscription = subscriptionService.updateSubscription(customerId, subscriptionId, subscriptionDto);
                return ResponseEntity.ok(subscription.getId());
            } catch (CustomerNotFoundException e) {
                logger.info(e.getMessage());
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.status(500).build();
    }

    @GetMapping(value = "/customers/{customerId}/subscriptions/{subscriptionId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Subscription> getSubscriptionForCustomer(@PathVariable String customerId, @PathVariable String subscriptionId) {
        try {
            Subscription subscription = subscriptionService.getSubscription(customerId, subscriptionId);
            return ResponseEntity.ok(subscription);
        } catch (CustomerNotFoundException | NullPointerException e) {
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
