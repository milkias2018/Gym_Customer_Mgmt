package com.gym.service;

import com.gym.dto.GroupTrainingDto;
import com.gym.entity.GroupTraining;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupTrainingService {
    GroupTraining AddGroupTraining(GroupTrainingDto groupTrainingDto);

    void removeGroupTraining(String id);

    GroupTraining updateGroupTraining(String groupTrainingId, GroupTrainingDto groupTrainingDto);

    List<GroupTraining> getGroupTrainings();
}
