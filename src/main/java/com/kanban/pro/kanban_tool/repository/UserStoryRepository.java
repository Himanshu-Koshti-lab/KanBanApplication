package com.kanban.pro.kanban_tool.repository;

import com.kanban.pro.kanban_tool.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory , Long> {

    @Query("select u from UserStory u where u.assignedTo = ?1")
    List<UserStory> findByAssignedTo(String assignedTo);



}
