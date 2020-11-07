package develop.gym.service;

import develop.gym.dao.AddressJpaDao;
import develop.gym.dao.CustomerDao;
import develop.gym.dto.AddressDto;
import develop.gym.entity.Address;
import develop.gym.entity.Customer;
import develop.gym.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImpl implements AddressService {

    private AddressJpaDao addressJpaDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    public AddressServiceImpl(AddressJpaDao addressJpaDao) {
        this.addressJpaDao = addressJpaDao;
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
    public Address updateAddress(String customerId, AddressDto addressDto) throws CustomerNotFoundException {
        if (customerId != null && addressDto != null) {
            Customer customer = customerDao.getCustomer(customerId);
            Address address = addressJpaDao.getOne(customer.getAddress().getId());

            address.setCity(addressDto.getCity());
            address.setCountry(addressDto.getCountry());
            address.setMunicipality(addressDto.getMunicipality());
            address.setRoomNumber(addressDto.getRoomNumber());
            address.setStreetName(addressDto.getStreetName());
            address.setStreetNumber(addressDto.getStreetNumber());
            address.setZipCode(addressDto.getZipCode());

            return addressJpaDao.save(address);

        }
        return null;
    }
}