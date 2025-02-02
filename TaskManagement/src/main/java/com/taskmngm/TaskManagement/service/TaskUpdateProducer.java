package com.taskmngm.taskmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskUpdateProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendTaskUpdate(String taskId, String status) {
        kafkaTemplate.send("task-updates", taskId, status);
    }
}
