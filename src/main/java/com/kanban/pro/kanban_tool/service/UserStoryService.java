package com.kanban.pro.kanban_tool.service;

import com.kanban.pro.kanban_tool.entity.UserStory;
import com.kanban.pro.kanban_tool.enums.StoryStatus;
import com.kanban.pro.kanban_tool.repository.UserStoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import static com.kanban.pro.kanban_tool.util.commonUtils.isEmptyOrNull;

@Service
public class UserStoryService {

    public UserStoryRepository userStoryRepository;

    UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public List<UserStory> getUserStories() {
        return userStoryRepository.findAll();
    }

    public UserStory getUserStoryById(Long id) {
        return userStoryRepository.findById(id).orElse(null);
    }

    public ResponseEntity<UserStory> updateStory(UserStory userStory) {
        boolean isUpdateDone = false;
        if (userStoryRepository.existsById(userStory.getId()))
            isUpdateDone = userStoryRepository.save(userStory).equals(userStory);
        return new ResponseEntity<>(userStory, HttpStatus.OK);
    }

    public ResponseEntity<String> create(String title, String desc) throws Exception {

        if (isEmptyOrNull(title))
            throw new Exception("UserStory Minimum requirement not match atleast title!!");

        UserStory build = UserStory.builder()
                .title(title)
                .description(desc)
                .status(StoryStatus.BACKLOG)
                .startTime(null)
                .lastUpdate(null)
                .build();

        UserStory saveData = userStoryRepository.save(build);

        return saveData.getId() < 0 ? new ResponseEntity<>("Failed to create Story", HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE) : new ResponseEntity<>("Story Created Successfully, Story Number : " + saveData.getId(), HttpStatus.OK);
    }

    public ResponseEntity<String> updateStoryStatus(Long id, String status) {
        boolean isUpdateDone = false;
        UserStory userStory =  userStoryRepository.findById(id).orElse(new UserStory());
        userStory.setStatus(StoryStatus.valueOf(status));
        if(Objects.equals(status, StoryStatus.IN_PROGRESS.name())){
            userStory.setStartTime(Timestamp.from(Instant.now()));
        }else{
            userStory.setLastUpdate(Timestamp.from(Instant.now()));
        }

        isUpdateDone = userStoryRepository.save(userStory).equals(userStory);
        return new ResponseEntity<>(isUpdateDone ? "Updated Done for " + id + " to Status : " + status : "Operation Failed.", HttpStatus.OK);
    }
}
