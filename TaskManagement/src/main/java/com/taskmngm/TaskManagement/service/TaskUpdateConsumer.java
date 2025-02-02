package com.taskmngm.taskmanagement.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TaskUpdateConsumer {

    private final FieldServiceRoutingService fieldServiceRoutingService;

    public TaskUpdateConsumer(FieldServiceRoutingService routingService) {
        this.fieldServiceRoutingService = routingService;
    }

    @KafkaListener(topics = "task-updates", groupId = "task-group")
    public void consumeTaskUpdate(String message) {
        // Parse the message (assuming it’s a JSON string for task details)
        System.out.println("Received task update: " + message);
        
        // Call routing logic to assign an agent based on the task details
        fieldServiceRoutingService.assignAgent(message);
    }
}
