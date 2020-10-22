package develop.gym.service;

import develop.gym.dto.AddressDto;
import develop.gym.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address saveAddress(AddressDto addressDto);
}