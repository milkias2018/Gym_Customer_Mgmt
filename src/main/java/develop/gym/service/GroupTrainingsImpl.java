package develop.gym.service;

import develop.gym.dao.GroupTrainingJpaDao;
import develop.gym.dto.GroupTrainingDto;
import develop.gym.entity.GroupTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupTrainingsImpl implements GroupTrainingService {

    private GroupTrainingJpaDao groupTrainingJpaDao;

    @Autowired
    public GroupTrainingsImpl(GroupTrainingJpaDao groupTrainingJpaDao) {
        this.groupTrainingJpaDao = groupTrainingJpaDao;
    }

    @Override
    public GroupTraining AddGroupTraining(GroupTrainingDto groupTrainingDto) {
        if (groupTrainingDto != null) {
            return groupTrainingJpaDao.save(GroupTrainingDto.convertToEntity(groupTrainingDto));
        }
        return null;
    }

    @Override
    public void removeGroupTraining(String id) {
        if (id != null)
            groupTrainingJpaDao.deleteById(id);
        else
            throw new NullPointerException();
    }

    @Override
    public GroupTraining updateGroupTraining(String groupTrainingId, GroupTrainingDto groupTrainingDto) {
        if (groupTrainingId != null && groupTrainingDto != null) {
            GroupTraining groupTraining = groupTrainingJpaDao.getOne(groupTrainingId);

            groupTraining.setTitle(groupTrainingDto.getTitle());
            groupTraining.setDescription(groupTrainingDto.getDescription());
            groupTraining.setTrainer(groupTrainingDto.getTrainer());
            groupTraining.setNumberOfParticipants(groupTrainingDto.getNumberOfParticipants());
            groupTraining.setRoomName(groupTrainingDto.getRoomName());

            return groupTrainingJpaDao.save(groupTraining);
        }
        return null;
    }

    @Override
    public List<GroupTraining> getGroupTrainings() {
        return null;
    }
}
