package com.ToDO_API.service;

import com.ToDO_API.model.Notification;
import com.ToDO_API.model.Task;
import com.ToDO_API.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskReminderService {

    @Autowired
    private TaskService taskService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private NotificationRepository notificationRepository;

    @Scheduled(fixedRate = 60000) // Run every minute
    public void checkDueTasks() {
        System.out.println("Checking for tasks due soon..."); // Log scheduler execution

        List<Task> tasksDueSoon = taskService.getTasksDueSoon();
        for (Task task : tasksDueSoon) {
            String subject = "Task Due Soon: " + task.getTitle();
            String text = "Your task '" + task.getTitle() + "' is due at " + task.getDueDate();
            String recipientEmail = "phillipthuto@gmail.com"; // Replace with the actual recipient email

            // Send the email
            notificationService.sendEmail(recipientEmail, subject, text);

            System.out.println("Reminder sent for task: " + task.getTitle()); // Log the reminder

            // Save the notification in the database
            Notification notification = new Notification();
            notification.setMessage(text);
            notification.setTimestamp(LocalDateTime.now());
            notification.setRecipientEmail(recipientEmail);
            notification.setSent(true); // Mark as sent
            notificationRepository.save(notification);
        }
    }
}