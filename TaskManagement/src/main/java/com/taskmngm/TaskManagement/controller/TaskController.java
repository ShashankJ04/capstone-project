package com.taskmngm.taskmanagement.controller;

import com.taskmngm.taskmanagement.model.Task;
import com.taskmngm.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @MutationMapping
    public Task createTask(String title, String description, String priority, String dueDate, String status, String assignedTo) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setDueDate(LocalDateTime.parse(dueDate));
        task.setStatus(status);
        task.setAssignedTo(assignedTo);
        return taskRepository.save(task);
    }
    // New updateTask mutation
    @MutationMapping
    public Task updateTask(Long id, String title, String description, String priority, String dueDate, String status, String assignedTo) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(title);
        task.setDescription(description);
        task.setPriority(priority);
        task.setDueDate(LocalDateTime.parse(dueDate));
        task.setStatus(status);
        task.setAssignedTo(assignedTo);
        return taskRepository.save(task);
    }

    // New deleteTask mutation
    @MutationMapping
    public String deleteTask(Long id) {
        taskRepository.deleteById(id);
        return "Task deleted successfully";
    }
}
