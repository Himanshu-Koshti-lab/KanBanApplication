package com.kanban.pro.kanban_tool.entity;

import com.kanban.pro.kanban_tool.enums.StoryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_story_seq")
    @SequenceGenerator(name = "user_story_seq", sequenceName = "user_story_seq", allocationSize = 1)
    Long id;
    String title;
    String description;
    StoryStatus status;
    Timestamp creationTime;
    Timestamp startTime;
    Timestamp lastUpdate;
    String createdBy;
    String assignedTo;

}