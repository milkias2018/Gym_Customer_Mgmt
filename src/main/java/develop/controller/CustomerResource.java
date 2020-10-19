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
import javax.ws.rs.QueryParam;


@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto) {

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerByPersonnummer(@QueryParam("id") String id) throws CustomerNotFoundException {
        try {
            if (id != null) {
                Customer customer = customerService.getCustomerByPersonNummer(id);
                return ResponseEntity.ok(customer);
            }
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
