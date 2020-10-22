package develop.gym.controller;

import com.google.gson.Gson;
import develop.gym.dto.AddressDto;
import develop.gym.entity.Address;
import develop.gym.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/addresses")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAddress(@RequestBody AddressDto addressDto) {
        try {
            if (addressDto != null) {

                Address address = addressService.saveAddress(addressDto);
                Gson gson = new Gson();
                return ResponseEntity.ok().body(gson.toJson(address.getId()));
            }
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
