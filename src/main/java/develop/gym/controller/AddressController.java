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

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/{customerId}/address",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAddress(@PathVariable String customerId, @RequestBody AddressDto addressDto) {
        try {
            if (addressDto != null && customerId != null) {
                Address address = addressService.saveAddress(customerId, addressDto);
                Gson gson = new Gson();
                return ResponseEntity.ok().body(gson.toJson(address.getId()));
            }
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
