package com.taskmngm.taskmanagement.controller;

import com.taskmngm.taskmanagement.model.Task;
import com.taskmngm.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;


@Controller
public class TaskQuery {

    @Autowired
    private TaskRepository taskRepository;

    // Fetch all tasks
    @QueryMapping
    public List<Task> allTasks() {
        return taskRepository.findAll();
    }

    // Fetch a specific task by ID
    @QueryMapping
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }
}
