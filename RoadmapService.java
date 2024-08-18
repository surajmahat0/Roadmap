// src/main/java/com/example/roadmap/service/RoadmapService.java
package com.example.roadmap_generator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RoadmapService {

    public Map<String, String> generateRoadmap(User user) {
        Map<String, String> roadmap = new HashMap<>();
        String standard = user.getStandard();
        String field = user.getFieldOfInterest();

        if ("12th".equalsIgnoreCase(standard) && "Computer Science".equalsIgnoreCase(field)) {
            roadmap.put("Step 1", "Learn Programming Basics (C/C++/Java)");
            roadmap.put("Step 2", "Get familiar with Data Structures and Algorithms");
            roadmap.put("Step 3", "Build small projects to practice");
            roadmap.put("Step 4", "Learn about Operating Systems and Networking");
            roadmap.put("Step 5", "Explore advanced topics like AI/ML or Web Development");
        } else {
            roadmap.put("Message", "Roadmap generation for the given input is not available.");
        }

        return roadmap;
    }
}
