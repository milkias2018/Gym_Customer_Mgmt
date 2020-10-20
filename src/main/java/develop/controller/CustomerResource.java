package develop.controller;

import develop.dto.CustomerDto;
import develop.entity.Customer;
import develop.exception.CustomerNotFoundException;
import develop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.ws.rs.QueryParam;


@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {

        try {
            if (customerDto != null) {
                CustomerDto customerDto1 = new CustomerDto(customerDto.getPersonNumber(), customerDto.getFirstName(), customerDto.getMiddleName(), customerDto.getLastName(), customerDto.getRegistrationDate(), customerDto.getMembershipType());
                Customer customer = CustomerDto.convertToEntity(customerDto1);
                customerService.saveCustomer(customer);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
        try {
            if (customerId != 0) {
                Customer customer = customerService.getCustomerById(customerId);
                return ResponseEntity.ok(customer);
            }
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerByPersonNummer(@QueryParam("personNummer") String personNummer) {
        try {
            if (personNummer != null) {
                Customer customer = customerService.getCustomerByPersonNummer(personNummer);
                return ResponseEntity.ok().body(customer);
            }
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
