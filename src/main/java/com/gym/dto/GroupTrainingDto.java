package com.gym.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gym.entity.GroupTraining;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupTrainingDto {

    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("trainer")
    private String trainer;
    @JsonProperty("roomName")
    private String roomName;
    @JsonProperty("numberOfParticipants")
    private int numberOfParticipants;

    public GroupTrainingDto(String title, String description, String trainer, String roomName, int numberOfParticipants) {
        this.title = title;
        this.description = description;
        this.trainer = trainer;
        this.roomName = roomName;
        this.numberOfParticipants = numberOfParticipants;
    }

    public GroupTrainingDto() {
    }

    public static GroupTraining convertToEntity(GroupTrainingDto groupTrainingDto) {

        if (groupTrainingDto != null) {
            GroupTraining groupTraining = new GroupTraining();
            groupTraining.setTitle(groupTrainingDto.getTitle());
            groupTraining.setDescription(groupTrainingDto.getDescription());
            groupTraining.setNumberOfParticipants(groupTrainingDto.getNumberOfParticipants());
            groupTraining.setRoomName(groupTrainingDto.getRoomName());
            groupTraining.setTrainer(groupTrainingDto.getTrainer());

            return groupTraining;
        }
        return null;
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
