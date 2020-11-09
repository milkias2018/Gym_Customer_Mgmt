package develop.gym.service;

import develop.gym.dto.GroupTrainingDto;
import develop.gym.entity.GroupTraining;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupTrainingService {
    GroupTraining AddGroupTraining(GroupTrainingDto groupTrainingDto);

    void removeGroupTraining(String id);

    void updateGroupTraining(String groupTrainingId, GroupTrainingDto groupTrainingDto);

    List<GroupTraining> getGroupTrainings();
}
