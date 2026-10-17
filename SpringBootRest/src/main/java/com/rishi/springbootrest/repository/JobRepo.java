package com.rishi.springbootrest.repository;

import com.rishi.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {
    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Java Developer", "Develop and maintain Java-based applications.", 2, Arrays.asList("Java", "Spring Boot", "MySQL", "Git")),
            new JobPost(2, "Frontend Developer", "Build responsive and user-friendly web applications.", 1, Arrays.asList("HTML", "CSS", "JavaScript", "React")),
            new JobPost(3, "Backend Developer", "Design and develop scalable backend services and APIs.", 3, Arrays.asList("Java", "Spring", "REST API", "PostgreSQL")),
            new JobPost(4, "Full Stack Developer", "Work on both frontend and backend development.", 2, Arrays.asList("Java", "Spring Boot", "React", "MongoDB")),
            new JobPost(5, "Python Developer", "Develop Python applications and data processing solutions.", 1, Arrays.asList("Python", "Django", "SQL", "Git"))));


    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println(jobs);
    }

    public JobPost getJob(int postId) {

        for(JobPost job: jobs){
            if(job.getPostId() == postId){
                return job;
            }
        }

        return null;
    }

    public void updateJob(JobPost jobPost) {
        for(JobPost jobPost1:jobs){
            if(jobPost1.getPostId() == jobPost.getPostId()){
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDescription(jobPost.getPostDescription());
                jobPost1.setRequiredExperience(jobPost.getRequiredExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }


    public void deleteJob(int postId) {
        for(JobPost jobPost: jobs){
            if(jobPost.getPostId() == postId){
                jobs.remove(jobPost);
            }
        }
    }
}
