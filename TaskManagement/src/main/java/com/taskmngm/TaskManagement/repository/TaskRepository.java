package com.taskmngm.taskmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.taskmngm.taskmanagement.model.Task;

public interface TaskRepository extends MongoRepository<Task, Long> {
    // Custom query methods (if needed)
}
