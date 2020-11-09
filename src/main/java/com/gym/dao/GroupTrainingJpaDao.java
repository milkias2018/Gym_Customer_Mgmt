package com.gym.dao;

import com.gym.entity.GroupTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTrainingJpaDao extends JpaRepository<GroupTraining, String> {
}
