package com.gym.service;

import com.gym.dao.AddressJpaDao;
import com.gym.dao.CustomerDao;
import com.gym.dto.AddressDto;
import com.gym.entity.Address;
import com.gym.entity.Customer;
import com.gym.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImpl implements AddressService {

    private AddressJpaDao addressJpaDao;
    private CustomerDao customerDao;

    @Autowired
    public AddressServiceImpl(AddressJpaDao addressJpaDao, CustomerDao customerDao) {
        this.addressJpaDao = addressJpaDao;
        this.customerDao = customerDao;
    }

    @Override
    public Address saveAddress(String customerId, AddressDto addressDto) throws CustomerNotFoundException {
        if (customerId != null && addressDto != null) {
            Customer customer = customerDao.getCustomer(customerId);
            if (customer.getAddress() == null) {
                return addressJpaDao.save(addressDto.convertToEntity(customer, addressDto));
            }
        }
        return null;
    }

    @Override
    public Address updateAddress(String customerId, String addressId, AddressDto addressDto) throws CustomerNotFoundException {
        if (customerId != null && addressId != null && addressDto != null) {
            Customer customer = customerDao.getCustomer(customerId);
            Address address = addressJpaDao.getOne(addressId);

            if (customer.getAddress().getId().equals(address.getId())) {
                address.setCity(addressDto.getCity());
                address.setCountry(addressDto.getCountry());
                address.setMunicipality(addressDto.getMunicipality());
                address.setRoomNumber(addressDto.getRoomNumber());
                address.setStreetName(addressDto.getStreetName());
                address.setStreetNumber(addressDto.getStreetNumber());
                address.setZipCode(addressDto.getZipCode());

                return addressJpaDao.save(address);
            }
        }
        return null;
    }

    @Override
    public Address getAddressForCustomer(String customerId, String addressId) throws CustomerNotFoundException {
        if (customerId != null && addressId != null) {
            Customer customer = customerDao.getCustomer(customerId);
            Address address = addressJpaDao.getOne(addressId);

            if (customer.getAddress().getId().equals(address.getId()))
                return addressJpaDao.getOne(customer.getAddress().getId());
            else
                throw new NullPointerException();
        }
        return null;
    }
}