package develop.gym.controller;

import develop.gym.dto.GroupTrainingDto;
import develop.gym.entity.GroupTraining;
import develop.gym.service.GroupTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/grouptrainings")
public class GroupTrainingController {

    private GroupTrainingService groupTrainingService;

    @Autowired
    public GroupTrainingController(GroupTrainingService groupTrainingService) {
        this.groupTrainingService = groupTrainingService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveGroupTraining(@RequestBody GroupTrainingDto groupTrainingDto) {
        if (groupTrainingDto != null) {
            GroupTraining groupTraining = groupTrainingService.AddGroupTraining(groupTrainingDto);
            return ResponseEntity.ok(groupTraining.getId());
        }
        return ResponseEntity.badRequest().build();
    }

}
