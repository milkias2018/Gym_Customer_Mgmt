package develop.gym.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupTrainingDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("personNumber")
    private String personNumber;
    @JsonProperty("description")
    private String description;
    @JsonProperty("trainer")
    private String trainer;
    @JsonProperty("roomName")
    private String roomName;
    @JsonProperty("numberOfParticipants")
    private int numberOfParticipants;

    public GroupTrainingDto(String id, String personNumber, String description, String trainer, String roomName, int numberOfParticipants) {
        this.id = id;
        this.personNumber = personNumber;
        this.description = description;
        this.trainer = trainer;
        this.roomName = roomName;
        this.numberOfParticipants = numberOfParticipants;
    }

    public GroupTrainingDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
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
