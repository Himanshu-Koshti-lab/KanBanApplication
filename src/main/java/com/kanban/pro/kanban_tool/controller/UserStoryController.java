package com.kanban.pro.kanban_tool.controller;

import com.kanban.pro.kanban_tool.entity.UserStory;
import com.kanban.pro.kanban_tool.service.UserStoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/")
public class UserStoryController {
    
    Logger LOGGER = LoggerFactory.getLogger(UserStoryController.class);

    UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }


    @PostMapping("create")
    public ResponseEntity<String> createStory(@RequestParam("title") String title, @RequestParam("desc") String desc){
        try {
           LOGGER.info("Creating story with title: {} and desc: {}", title, desc);
            return userStoryService.create(title, desc);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getUserStories")
    public List<UserStory> getAllStories() {
       LOGGER.info("Getting all user stories");
        return userStoryService.getUserStories();
    }

    @GetMapping("getUserStory/{id}")
    public UserStory getStory(@PathVariable("id") Long id) {
       LOGGER.info("Getting user story with id: {}", id);
        return userStoryService.getUserStoryById(id);
    }

    @PostMapping("update")
    public ResponseEntity<UserStory> updateStory(@RequestBody UserStory userStory){
       LOGGER.info("Updating user story with id: {}", userStory.getId());
        return userStoryService.updateStory(userStory);
    }


    @PostMapping("updateStatus")
    public ResponseEntity<String> updateStoryStatus( @RequestParam Long id, @RequestParam String status){
       LOGGER.info("Updating user story Status {} with id: {}", status, id);
        return userStoryService.updateStoryStatus(id, status);
    }

    @GetMapping("getUserStoriesByAsignee")
    public ResponseEntity<List<UserStory>> getUserStoriesByAsignee(@RequestParam String assignedTo) {
        try {
            return ResponseEntity.ok(userStoryService.getStoriesByAsignee(assignedTo));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("error")
    public ResponseEntity<String> error() throws Exception {
        throw new Exception("Something went wrong...Internal...");
    }

}
