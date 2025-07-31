package com.kanban.pro.kanban_tool.controller;

import com.kanban.pro.kanban_tool.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboard {

    @Autowired
    UserStoryService userStoryService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("stories", userStoryService.getUserStories());
        return "userstory";
    }
}
