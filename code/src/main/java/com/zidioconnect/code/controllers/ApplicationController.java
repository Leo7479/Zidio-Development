package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.Application;
import com.zidioconnect.code.services.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final IApplicationService applicationService;

    @Autowired
    public ApplicationController(IApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAll(){
        return applicationService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> applyToJob(@RequestBody Application application) {
        try {
            if (application == null || application.getStudent() == null || application.getJobPosting() == null) {
                return new ResponseEntity<>("Invalid application data", HttpStatus.BAD_REQUEST);
            }

            Application createdApplication = applicationService.createApplication(application);
            return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while applying to job: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getApplicationsByStudent(@PathVariable long studentId) {
        try {
            List<Application> applications = applicationService.getApplicationsByStudent(studentId);
            if (applications == null) {
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching applications: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<?> getApplicationsByJob(@PathVariable long jobId) {
        try {
            List<Application> applications = applicationService.getApplicationsByJob(jobId);
            if (applications == null) {
                return new ResponseEntity<>("Job posting not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(applications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching applications: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public Application deleteApplicationById(@PathVariable long id){
        return applicationService.deleteById(id);
    }

    @PutMapping("/update")
    public Application update(@RequestBody Application application){
        return applicationService.update(application);
    }
}
