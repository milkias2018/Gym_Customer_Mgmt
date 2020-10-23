package develop.gym.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "GROUP_TRAININGS")
public class GroupTraining implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private UUID id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TRAINER")
    private String trainer;
    @Column(name = "ROOM_NAME")
    private String roomName;
    @Column(name = "NUMBER_OF_PARTICIPANTS")
    private int numberOfParticipants;

    public GroupTraining(UUID id, String name, String description, String trainer, String roomName, int numberOfParticipants) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.trainer = trainer;
        this.roomName = roomName;
        this.numberOfParticipants = numberOfParticipants;
    }

    public GroupTraining() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
