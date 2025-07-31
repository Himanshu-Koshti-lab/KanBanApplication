package com.kanban.pro.kanban_tool.repository;

import com.kanban.pro.kanban_tool.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory , Long> {
}
