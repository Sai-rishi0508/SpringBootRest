package com.rishi.springbootrest;

import com.rishi.springbootrest.model.JobPost;
import com.rishi.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
//The @CrossOrigin annotation is used to allow requests from a different origin (URL) to access a Spring Boot application.
//here we are trying to link our front-end with our backend(AllPosts.jsx to SpringBootApplication) if we do that without @CrossOrigin due to security reasons the linking will not be allowed.

public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("JobPosts")
    //@ResponseBody//tells Spring that the return value of a controller method should be sent directly in the HTTP response body instead of being interpreted as the name of a view.
    //if we are using @RestController instead of @Controller there is no need of using @ResponseBody
    public List<JobPost> getAlljobs(){
        return service.getAllJobs();
    }

    @GetMapping("JobPost/{postId}")
    //@PathVariable is used to extract a value from the URL and store it in a method parameter.
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("/JobPost")
    //In Spring Boot, @RequestBody is used to receive data from the body of an HTTP request and convert it into a Java object.
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PostMapping("/test")
    public String test() {
        return "POST endpoint is working";
    }

    @PutMapping("JobPost/{postId}")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("JobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

}
