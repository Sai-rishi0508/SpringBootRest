package com.rishi.springbootrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {
    private int postId;
    private String postProfile;
    private String postDescription;
    private int requiredExperience;
    private List<String> postTechStack;

    //lombok helps us to reduce number of lines of our code
}
