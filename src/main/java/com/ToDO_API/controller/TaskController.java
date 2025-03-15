package com.ToDO_API.controller;

import com.ToDO_API.model.Task;
import com.ToDO_API.service.NotificationService;
import com.ToDO_API.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tasks")
@RestController
//@RequestMapping("/test")//
public class TaskController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/send-email")
    public String sendTestEmail() {
        notificationService.sendEmail("phillipthuto@gmail.com", "Test Email", "This is a test email.");
        return "Test email sent!";
    }

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}