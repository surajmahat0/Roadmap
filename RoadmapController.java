package com.example.roadmap_generator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class RoadmapController {

    @PostMapping("/generate-roadmap")
    public ResponseEntity<Map<String, Object>> generateRoadmap(@RequestBody UserInput input) {
        List<String> roadmap = new ArrayList<>();

        switch (input.getStandard().toLowerCase()) {
            case "10th":
                roadmap.add("Step 1: Complete 10th grade with good marks.");
                roadmap.add("Step 2: Choose a stream for higher studies (Science, Commerce, Arts).");
                roadmap.add("Step 3: Select subjects based on the chosen stream.");
                roadmap.add("Step 4: Prepare for entrance exams if needed.");
                roadmap.add("Step 5: Apply for colleges or schools based on your stream.");
                break;
            case "12th":
                roadmap.add("Step 1: Complete 12th grade with good marks.");
                roadmap.add("Step 2: Choose a career path (Engineering, Medical, Commerce, Arts).");
                roadmap.add("Step 3: Prepare for entrance exams for your chosen path.");
                roadmap.add("Step 4: Apply for undergraduate programs or courses.");
                break;
            case "diploma":
                roadmap.add("Step 1: Complete the diploma course with a focus on practical skills.");
                roadmap.add("Step 2: Gain experience through internships or projects.");
                roadmap.add("Step 3: Consider further studies or enter the job market.");
                break;
            case "b tech":
                switch (input.getFieldOfInterest().toLowerCase()) {
                    case "computer science":
                        roadmap.add("Step 1: Complete B.Tech in Computer Science with a good academic record.");
                        roadmap.add("Step 2: Build a strong portfolio with projects and internships.");
                        roadmap.add("Step 3: Prepare for coding interviews and placement drives.");
                        roadmap.add("Step 4: Apply for software engineering roles or consider further studies (M.Tech, MS).");
                        break;
                    case "electrical engineering":
                        roadmap.add("Step 1: Complete B.Tech in Electrical Engineering with a focus on core subjects.");
                        roadmap.add("Step 2: Gain practical experience through labs and internships.");
                        roadmap.add("Step 3: Prepare for placement drives or consider higher studies (M.Tech, MS).");
                        roadmap.add("Step 4: Explore career opportunities in power systems, electronics, or automation.");
                        break;
                    // Add more fields as needed
                    default:
                        roadmap.add("No predefined roadmap available for the given field of interest.");
                        break;
                }
                break;
            case "ba":
                switch (input.getFieldOfInterest().toLowerCase()) {
                    case "english":
                        roadmap.add("Step 1: Complete BA in English with a focus on literature and linguistics.");
                        roadmap.add("Step 2: Gain experience through internships, writing projects, or teaching.");
                        roadmap.add("Step 3: Consider pursuing an MA in English or related fields.");
                        roadmap.add("Step 4: Explore career opportunities in writing, publishing, or education.");
                        break;
                    case "history":
                        roadmap.add("Step 1: Complete BA in History with a focus on historical research and analysis.");
                        roadmap.add("Step 2: Engage in historical research projects or internships.");
                        roadmap.add("Step 3: Pursue an MA or MPhil in History or related fields.");
                        roadmap.add("Step 4: Explore career opportunities in research, teaching, or museums.");
                        break;
                    // Add more fields as needed
                    default:
                        roadmap.add("No predefined roadmap available for the given field of interest.");
                        break;
                }
                break;
            case "ca":
                roadmap.add("Step 1: Complete CA course including all levels (CPT, IPCC, Final).");
                roadmap.add("Step 2: Gain experience through articleship and practical training.");
                roadmap.add("Step 3: Consider specializing in areas such as taxation, audit, or finance.");
                roadmap.add("Step 4: Explore career opportunities as a Chartered Accountant or in finance roles.");
                break;
            case "b com":
                switch (input.getFieldOfInterest().toLowerCase()) {
                    case "finance":
                        roadmap.add("Step 1: Complete B.Com with a focus on finance subjects.");
                        roadmap.add("Step 2: Gain practical experience through internships or projects.");
                        roadmap.add("Step 3: Consider pursuing professional courses (e.g., CFA) or an MBA.");
                        roadmap.add("Step 4: Apply for roles in finance, accounting, or investment.");
                        break;
                    case "marketing":
                        roadmap.add("Step 1: Complete B.Com with a focus on marketing subjects.");
                        roadmap.add("Step 2: Gain practical experience through internships or projects in marketing.");
                        roadmap.add("Step 3: Consider pursuing an MBA with a specialization in marketing.");
                        roadmap.add("Step 4: Explore career opportunities in marketing, sales, or brand management.");
                        break;
                    // Add more fields as needed
                    default:
                        roadmap.add("No predefined roadmap available for the given field of interest.");
                        break;
                }
                break;
            // Add more educational levels and fields as needed
            default:
                roadmap.add("No predefined roadmap available for the given educational level.");
                break;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("steps", roadmap);
        return ResponseEntity.ok(response);
    }
}

class UserInput {
    private String standard;
    private String fieldOfInterest;

    // Getters and setters
    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getFieldOfInterest() {
        return fieldOfInterest;
    }

    public void setFieldOfInterest(String fieldOfInterest) {
        this.fieldOfInterest = fieldOfInterest;
    }
}
