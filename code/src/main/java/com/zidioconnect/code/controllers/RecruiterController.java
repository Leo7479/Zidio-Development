package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.Recruiter;
import com.zidioconnect.code.services.IRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {
    private final IRecruiterService recruiterService;
    @Autowired
    public RecruiterController(IRecruiterService  recruiterService){
        this.recruiterService = recruiterService;
    }

    @GetMapping()
    public ResponseEntity<List<Recruiter>> getAll(){
        try {
            return new ResponseEntity<>(recruiterService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getById(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(recruiterService.getById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/u")
    public ResponseEntity<Recruiter> getByUser_Id(@RequestParam("user_id") long user_id){
        try {
            return new ResponseEntity<>(recruiterService.getByUser_Id(user_id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<Recruiter>> getByName(@RequestParam("name") String name){
        try {
            return new ResponseEntity<>(recruiterService.getByName(name), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Recruiter> create(@RequestBody Recruiter recruiter){
        try {
            return new ResponseEntity<>(recruiterService.create(recruiter), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Recruiter> update(@RequestBody Recruiter recruiter){
        try {
            return new ResponseEntity<>(recruiterService.update(recruiter), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Recruiter> deleteById(@PathVariable("id") long id){
        try {
            return new ResponseEntity<>(recruiterService.deleteById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
