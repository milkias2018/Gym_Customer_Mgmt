package develop.gym.entity;

import develop.gym.dto.GroupTrainingDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GROUP_TRAININGS")
public class GroupTraining implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TRAINER")
    private String trainer;
    @Column(name = "ROOM_NAME")
    private String roomName;
    @Column(name = "NUMBER_OF_PARTICIPANTS")
    private int numberOfParticipants;

    public GroupTraining(String title, String description, String trainer, String roomName, int numberOfParticipants) {
        this.title = title;
        this.description = description;
        this.trainer = trainer;
        this.roomName = roomName;
        this.numberOfParticipants = numberOfParticipants;
    }

    public GroupTraining() {
    }

    public static GroupTraining convertToEntity(GroupTrainingDto groupTrainingDto) {
        GroupTraining groupTraining = new GroupTraining();

        groupTraining.setTitle(groupTrainingDto.getTitle());
        groupTraining.setDescription(groupTrainingDto.getDescription());
        groupTraining.setTrainer(groupTrainingDto.getTrainer());
        groupTraining.setNumberOfParticipants(groupTrainingDto.getNumberOfParticipants());
        groupTraining.setRoomName(groupTrainingDto.getRoomName());

        return groupTraining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }
}
