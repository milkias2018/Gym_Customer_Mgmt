package com.gym.controller;

import com.google.gson.Gson;
import com.gym.dto.CustomerDto;
import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import com.gym.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerResource extends BaseResource {

    private static final Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    CustomerService customerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/customers")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto) {

        try {
            if (customerDto != null) {
                CustomerDto customerDto1 = new CustomerDto(customerDto.getPersonNumber(),
                        customerDto.getFirstName(),
                        customerDto.getMiddleName(),
                        customerDto.getLastName(),
                        customerDto.getPhoneNumber(),
                        customerDto.getNumberOfBookingAllowedPerWeek(),
                        customerDto.getMemberSince());
                Customer customer = CustomerDto.convertToEntity(customerDto1);
                customerService.saveCustomer(customer);
                Gson gson = new Gson();
                logger.info("Created Customer" + " with ID: " + customer.getId());
                return ResponseEntity.ok().body(gson.toJson("Customer ID: " + customer.getId()));
            }
        } catch (NullPointerException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/customers/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) throws CustomerNotFoundException {
        try {
            if (customerId != null) {
                Customer customer = customerService.getCustomerById(customerId);
                return ResponseEntity.ok(customer);
            }
        } catch (CustomerNotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/customers/pnr/{personNummer}")
    public ResponseEntity<Customer> getCustomerByPersonNummer(@PathVariable String personNummer) {
        try {
            if (personNummer != null) {
                Customer customer = customerService.getCustomerByPersonNummer(personNummer);
                return ResponseEntity.ok().body(customer);
            }
        } catch (CustomerNotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (NoResultException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> removeCustomer(@PathVariable("id") String id) {

        try {
            if (id != null) {
                customerService.removeCustomer(id);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        try {
            if (id != null && customer != null) {
                customerService.update(id, customer);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }

    @GetMapping(value = "/customers/records", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomers() throws CustomerNotFoundException {

        try {
            return ResponseEntity.ok(customerService.getCustomers());
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
