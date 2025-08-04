package com.kanban.pro.kanban_tool.controller;

import com.kanban.pro.kanban_tool.service.UserStoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Dashboard {

    @Autowired
    UserStoryService userStoryService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        log.info("Loading Dashboard...");
        model.addAttribute("stories", userStoryService.getUserStories());
        return "userstory";
    }
}
