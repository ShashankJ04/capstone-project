package com.taskmngm.taskmanagement.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FieldServiceRoutingService {

    // Sample list of agents (in a real-world application, this would be retrieved from a DB)
    private List<Agent> agents = List.of(
        new Agent("agent1", "LocationA", "plumbing", true),
        new Agent("agent2", "LocationB", "electrician", true)
    );

    public void assignAgent(String taskDetails) {
        // Parse taskDetails (JSON) to retrieve task location, skill, etc.
        System.out.println("Assigning agent for task: " + taskDetails);

        // Filter agents based on location, skill match, and availability
        Agent bestAgent = findBestAgent(taskDetails);

        if (bestAgent != null) {
            System.out.println("Assigned Agent: " + bestAgent.getName());
        } else {
            System.out.println("No suitable agent found.");
        }
    }

    private Agent findBestAgent(String taskDetails) {
        // Logic to filter and select the best agent (simplified here)
        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                return agent;
            }
        }
        return null;
    }
}

class Agent {
    private String name;
    private String location;
    private String skill;
    private boolean available;

    // Constructor
    public Agent(String name, String location, String skill, boolean available) {
        this.name = name;
        this.location = location;
        this.skill = skill;
        this.available = available;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for skill
    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    // Getter and Setter for available
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
