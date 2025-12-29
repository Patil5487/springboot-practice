package com.YashodhanPati.SpringBoot.JPA.Controller;

import com.YashodhanPati.SpringBoot.JPA.Model.JobPost;
import com.YashodhanPati.SpringBoot.JPA.Repo.JobRepo;
import com.YashodhanPati.SpringBoot.JPA.Service.JobService;
import jakarta.persistence.Access;
import org.hibernate.query.sqm.mutation.internal.temptable.LocalTemporaryTableInsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JobController {

    @Autowired
    private JobService jobService;

    // Get all Jobs
    @GetMapping("jobPosts")
    public List<JobPost> getAllPosts() {
        return jobService.getALlJobs();
    }

    //Search
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.search(keyword);

    }

    // GetJob by ID
    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return jobService.getJob(postId);
    }

    // Add A single Job
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    // Adds a multiple jobs at a time
    @PostMapping("jobPosts")
    public List<JobPost> addJobs(@RequestBody List<JobPost> jobs){
        jobService.addJobs(jobs);
        return jobs;
    }

    // Update Job
    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    // Delete a Job
    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
        return "Job Deleted Successfully";
    }

    // Loads data
    @GetMapping("load")
    public String loadData(){
        jobService.load();
        return "Job Loaded Successfully";
    }
}
