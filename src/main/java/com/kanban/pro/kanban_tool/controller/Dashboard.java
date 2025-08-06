package com.kanban.pro.kanban_tool.controller;

import com.kanban.pro.kanban_tool.service.UserStoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboard {

    Logger LOGGER = LoggerFactory.getLogger(Dashboard.class);

    @Autowired
    UserStoryService userStoryService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        LOGGER.info("Loading Dashboard...");
        model.addAttribute("stories", userStoryService.getUserStories());
        return "userstory";
    }
}
