package com.gym.dao;

import com.gym.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJpaDao extends JpaRepository<Address, String> {
}