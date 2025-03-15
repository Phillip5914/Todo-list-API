package com.ToDO_API.repository;

import com.ToDO_API.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);

    List<Task> findByDueDateBetween(LocalDateTime now, LocalDateTime soon);
}