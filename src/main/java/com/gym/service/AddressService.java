package com.gym.service;

import com.gym.dto.AddressDto;
import com.gym.entity.Address;
import com.gym.exception.CustomerNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    Address saveAddress(String customerId, AddressDto addressDto) throws CustomerNotFoundException;

    Address updateAddress(String customerId, String addressId, AddressDto addressDto) throws CustomerNotFoundException;

    Address getAddressForCustomer(String customerId, String addressId) throws CustomerNotFoundException;
}