package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.JobPosting;
import com.zidioconnect.code.services.IJobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-postings")
public class JobPostingController {
    private final IJobPostingService jobPostingService;
    @Autowired
    public JobPostingController(IJobPostingService jobPostingService){
        this.jobPostingService = jobPostingService;
    }

    @GetMapping
    public ResponseEntity<List<JobPosting>> getAll(){
        try{
            return new ResponseEntity<>(jobPostingService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobPosting> getById(@PathVariable("id") long id){
        try{
            return new ResponseEntity<>(jobPostingService.getById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<JobPosting>> getByName(@RequestParam("name") String name){
        try{
            return new ResponseEntity<>(jobPostingService.getByName(name), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<JobPosting> create(@RequestBody JobPosting jobPosting){
        try{
            return new ResponseEntity<>(jobPostingService.create(jobPosting), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<JobPosting> update(@RequestBody JobPosting jobPosting){
        try{
            return new ResponseEntity<>(jobPostingService.update(jobPosting), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JobPosting> deleteById(@PathVariable("id") long id){
        try{
            return new ResponseEntity<>(jobPostingService.deleteById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
