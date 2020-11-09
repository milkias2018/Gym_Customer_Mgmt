package develop.gym.controller;

import develop.gym.dto.GroupTrainingDto;
import develop.gym.entity.GroupTraining;
import develop.gym.service.GroupTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/grouptrainings")
public class GroupTrainingController {

    private GroupTrainingService groupTrainingService;

    @Autowired
    public GroupTrainingController(GroupTrainingService groupTrainingService) {
        this.groupTrainingService = groupTrainingService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveGroupTraining(@RequestBody GroupTrainingDto groupTrainingDto) {
        if (groupTrainingDto != null) {
            GroupTraining groupTraining = groupTrainingService.AddGroupTraining(groupTrainingDto);
            return ResponseEntity.ok(groupTraining.getId());
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(value = "/{groupTrainingId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupTraining> removeGroupTraining(@PathVariable String groupTrainingId) {

        try {
            if (groupTrainingId != null) {
                groupTrainingService.removeGroupTraining(groupTrainingId);
                return ResponseEntity.ok().build();
            }
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(500).build();
    }

    @PutMapping(value = "/{groupTrainingId}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> updateGroupTraining(@PathVariable String groupTrainingId, @RequestBody GroupTrainingDto groupTrainingDto) {
        try {
            if (groupTrainingId != null && groupTrainingDto != null) {
                GroupTraining groupTraining = groupTrainingService.updateGroupTraining(groupTrainingId, groupTrainingDto);
                return ResponseEntity.ok(groupTraining.getId());
            }
        } catch (NullPointerException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(500).build();
    }

}