Todo List API

A Spring Boot-based Todo List API with email reminders. Users can create, update, and delete tasks, and receive email notifications for tasks due soon.


Features
- Create Tasks: Add new tasks with a title, description, due date, and completion status.
- Update Tasks: Modify existing tasks.
- Delete Tasks: Remove tasks from the list.
- Email Reminders: Receive email notifications for tasks due within the next hour.
- RESTful API: Built using Spring Boot and follows REST conventions.

Technologies Used
- Spring Boot: Backend framework for building the API.
- Spring Data JPA: For database operations.
- H2 Database: For storing tasks and notifications.
- Spring Mail: For sending email reminders.
- Spring Scheduling: For running background tasks (e.g., checking for due tasks).
- Postman: For testing the API endpoints.

Setup Instructions

Prerequisites
- Java 17
- Maven
- H2 for in-memory database
- Gmail account (for email notifications)

Steps to Run the Project
1. Clone the Repository:
   git clone https://github.com/your-username/todo-list-api.git
