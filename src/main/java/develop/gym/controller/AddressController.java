package develop.gym.controller;

import com.google.gson.Gson;
import develop.gym.dto.AddressDto;
import develop.gym.entity.Address;
import develop.gym.exception.CustomerNotFoundException;
import develop.gym.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class AddressController {

    private AddressService addressService;
    Gson gson = new Gson();

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping(value = "/{customerId}/address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> createAddress(@PathVariable String customerId, @RequestBody AddressDto addressDto) {
        try {
            if (addressDto != null && customerId != null) {
                Address address = addressService.saveAddress(customerId, addressDto);
                return ResponseEntity.ok().body(gson.toJson("Address ID: " + address.getId()));
            }
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body(gson.toJson(e.getMessage()));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping(value = "/{customerId}/address",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAddress(@PathVariable String customerId, @RequestBody AddressDto addressDto) {
        try {
            if (addressDto != null && customerId != null) {
                Address address = addressService.updateAddress(customerId, addressDto);
                return ResponseEntity.ok().body(gson.toJson("Address ID: " + address.getId()));
            }
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().body(gson.toJson(e.getMessage()));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping(value = "/{customerId}/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> getAddressOfCustomer(@PathVariable String customerId) {
        try {
            Address address = addressService.getAddressForCustomer(customerId);
            return ResponseEntity.ok(address);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
