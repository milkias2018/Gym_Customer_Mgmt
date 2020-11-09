package com.gym.controller;

import com.gym.dto.SubscriptionDto;
import com.gym.entity.Subscription;
import com.gym.exception.CustomerNotFoundException;
import com.gym.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/customers")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping(value = "/{customerId}/subscription",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> AddSubscription(@PathVariable String customerId, @RequestBody SubscriptionDto subscriptionDto) {
        if (customerId != null && subscriptionDto != null) {
            Subscription subscription = null;
            try {
                subscription = subscriptionService.AddSubscription(customerId, subscriptionDto);
                return ResponseEntity.ok(subscription.getId());
            } catch (CustomerNotFoundException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.status(500).build();
    }

    @PutMapping(value = "/{customerId}/subscription",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> updateSubscription(@PathVariable String customerId, @RequestBody SubscriptionDto subscriptionDto) {

        if (customerId != null && subscriptionDto != null) {
            Subscription subscription = null;
            try {
                subscription = subscriptionService.updateSubscription(customerId, subscriptionDto);
                return ResponseEntity.ok(subscription.getId());
            } catch (CustomerNotFoundException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.status(500).build();
    }

    @GetMapping(value = "/{customerId}/subscription",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Subscription> getSubscriptionForCustomer(@PathVariable String customerId) {
        try {
            Subscription subscription = subscriptionService.getSubscription(customerId);
            return ResponseEntity.ok(subscription);
        } catch (CustomerNotFoundException | NullPointerException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
