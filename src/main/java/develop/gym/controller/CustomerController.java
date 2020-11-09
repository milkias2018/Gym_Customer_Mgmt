package develop.gym.controller;

import com.google.gson.Gson;
import develop.gym.dto.CustomerDto;
import develop.gym.entity.Customer;
import develop.gym.exception.CustomerNotFoundException;
import develop.gym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.ws.rs.QueryParam;
import java.util.List;


@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto) {

        try {
            if (customerDto != null) {
                CustomerDto customerDto1 = new CustomerDto(customerDto.getPersonNumber(),
                        customerDto.getFirstName(),
                        customerDto.getMiddleName(),
                        customerDto.getLastName(),
                        customerDto.getPhoneNumber(),
                        customerDto.getAddressDto(),
                        customerDto.getMembershipDto(),
                        customerDto.getNumberOfBookingAllowedPerWeek(),
                        customerDto.getMemberSince());
                Customer customer = CustomerDto.convertToEntity(customerDto1);
                customerService.saveCustomer(customer);
                Gson gson = new Gson();
                return ResponseEntity.ok().body(gson.toJson("Customer ID: " + customer.getId()));
            }
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) throws CustomerNotFoundException {
        try {
            if (customerId != null) {
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

    @DeleteMapping(value = "/{id}")
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

    @PutMapping(value = "/{id}")
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

    @GetMapping(value = "/records", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomers() throws CustomerNotFoundException {

        try {
            return ResponseEntity.ok(customerService.getCustomers());
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
