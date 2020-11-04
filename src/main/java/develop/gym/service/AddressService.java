package develop.gym.service;

import develop.gym.dto.AddressDto;
import develop.gym.entity.Address;
import develop.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address saveAddress(String customerId, AddressDto addressDto) throws CustomerNotFoundException;
}