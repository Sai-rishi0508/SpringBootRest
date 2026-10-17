package com.rishi.springbootrest.service;

import com.rishi.springbootrest.model.JobPost;
import com.rishi.springbootrest.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobService {
    @Autowired
    private JobRepo repository;

    public void addJob(JobPost jobPost){
        repository.addJob(jobPost);//here jobPost is a DTO(Data Transfer Object)
    }

    public List<JobPost> getAllJobs(){
        return repository.getAllJobs();
    }

    public JobPost getJob(int postId) {
        return repository.getJob(postId);
    }

    public void updateJob(JobPost jobPost) {
        repository.updateJob(jobPost);
    }

    public void deleteJob(int postId) {
        repository.deleteJob(postId);
    }
}
