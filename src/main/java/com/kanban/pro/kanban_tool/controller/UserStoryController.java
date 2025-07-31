package com.kanban.pro.kanban_tool.controller;

import com.kanban.pro.kanban_tool.entity.UserStory;
import com.kanban.pro.kanban_tool.service.UserStoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/")
public class UserStoryController {

    UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }


    @PostMapping("create")
    public ResponseEntity<String> createStory(@RequestParam("title") String title, @RequestParam("desc") String desc){
        try {
            return userStoryService.create(title, desc);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getUserStories")
    public List<UserStory> getAllStories() {
        return userStoryService.getUserStories();
    }

    @GetMapping("getUserStory/{id}")
    public UserStory getStory(@PathVariable("id") Long id) {
        return userStoryService.getUserStoryById(id);
    }

    @PostMapping("update")
    public ResponseEntity<UserStory> updateStory(@RequestBody UserStory userStory){
        return userStoryService.updateStory(userStory);
    }


    @PostMapping("updateStatus")
    public ResponseEntity<String> updateStoryStatus( @RequestParam Long id, @RequestParam String status){
        return userStoryService.updateStoryStatus(id, status);
    }

}
