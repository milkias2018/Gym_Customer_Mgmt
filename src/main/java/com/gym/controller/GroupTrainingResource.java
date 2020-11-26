package com.gym.controller;

import com.gym.dto.GroupTrainingDto;
import com.gym.entity.GroupTraining;
import com.gym.service.GroupTrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class GroupTrainingResource {

    private static final Logger logger = LoggerFactory.getLogger(GroupTrainingResource.class);
    private GroupTrainingService groupTrainingService;

    @Autowired
    public GroupTrainingResource(GroupTrainingService groupTrainingService) {
        this.groupTrainingService = groupTrainingService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            value = "/grouptrainings")
    public ResponseEntity<String> saveGroupTraining(@RequestBody GroupTrainingDto groupTrainingDto) {
        if (groupTrainingDto != null) {
            GroupTraining groupTraining = groupTrainingService.AddGroupTraining(groupTrainingDto);
            logger.info("Group Training Id: " + groupTraining.getId());
            return ResponseEntity.ok(groupTraining.getId());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/grouptrainings/{grouptrainingsid}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupTraining> removeGroupTraining(@PathVariable String groupTrainingId) {

        try {
            if (groupTrainingId != null) {
                groupTrainingService.removeGroupTraining(groupTrainingId);
                return ResponseEntity.ok().build();
            }
        } catch (NullPointerException e) {
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(500).build();
    }

    @PutMapping(value = "/grouptrainings/{grouptrainingsid}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> updateGroupTraining(@PathVariable String grouptrainingsid, @RequestBody GroupTrainingDto groupTrainingDto) {
        try {
            if (grouptrainingsid != null && groupTrainingDto != null) {
                GroupTraining groupTraining = groupTrainingService.updateGroupTraining(grouptrainingsid, groupTrainingDto);
                return ResponseEntity.ok(groupTraining.getId());
            }
        } catch (NullPointerException e) {
            logger.info(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(500).build();
    }

}