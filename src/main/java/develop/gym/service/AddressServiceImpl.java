package develop.gym.service;

import develop.gym.dao.AddressJpaDao;
import develop.gym.dto.AddressDto;
import develop.gym.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImpl implements AddressService {

    private AddressJpaDao addressJpaDao;

    @Autowired
    public AddressServiceImpl(AddressJpaDao addressJpaDao) {
        this.addressJpaDao = addressJpaDao;
    }

    @Override
    public Address saveAddress(AddressDto addressDto) {
        if (addressDto != null) {
            return addressJpaDao.save(AddressDto.convertToEntity(addressDto));
        } else
            throw new NullPointerException();
    }
}