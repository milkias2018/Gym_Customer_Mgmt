package com.gym.controller;

import com.google.gson.Gson;
import com.gym.dto.AddressDto;
import com.gym.entity.Address;
import com.gym.exception.CustomerNotFoundException;
import com.gym.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class AddressResource {
    private static final Logger logger = LoggerFactory.getLogger(AddressResource.class);
    private AddressService addressService;
    Gson gson = new Gson();

    @Autowired
    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping(value = "/customers/{customerId}/address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> createAddress(@PathVariable String customerId, @RequestBody AddressDto addressDto) {
        try {
            if (addressDto != null && customerId != null) {
                Address address = addressService.saveAddress(customerId, addressDto);
                return ResponseEntity.ok().body(gson.toJson("Address ID: " + address.getId()));
            }
        } catch (NullPointerException e) {
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().body(gson.toJson(e.getMessage()));
        } catch (CustomerNotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping(value = "/customers/{customerId}/addresses/{addressId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAddress(@PathVariable String customerId, @PathVariable String addressId, @RequestBody AddressDto addressDto) {
        try {
            if (addressDto != null && customerId != null && addressId != null) {
                Address address = addressService.updateAddress(customerId, addressId, addressDto);
                logger.info("Address Created" + " with ID: " + address.getId());
                return ResponseEntity.ok().body(gson.toJson("Address ID: " + address.getId()));
            }
        } catch (NullPointerException e) {
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().body(gson.toJson(e.getMessage()));
        } catch (CustomerNotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/customers/{customerId}/addresses/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> getAddressOfCustomer(@PathVariable String customerId, @PathVariable String addressId) {
        try {
            Address address = addressService.getAddressForCustomer(customerId, addressId);
            return ResponseEntity.ok(address);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
