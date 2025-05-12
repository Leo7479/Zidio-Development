package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.Recruiter;
import com.zidioconnect.code.services.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {
    private final RecruiterService recruiterService;
    @Autowired
    public RecruiterController(RecruiterService  recruiterService){
        this.recruiterService = recruiterService;
    }

    @GetMapping()
    public List<Recruiter> getAll(){
        return recruiterService.getAll();
    }

    @GetMapping("/{id}")
    public Recruiter getById(@PathVariable("id") long id){
        return recruiterService.getById(id);
    }

    @GetMapping("/find")
    public Recruiter getByUser_Id(@RequestParam("user_id") long user_id){
        return recruiterService.getByUser_Id(user_id);
    }

    @GetMapping("/find")
    public List<Recruiter> getByName(@RequestParam("name") String name){
        return recruiterService.getByName(name);
    }

    @PostMapping("/create")
    public Recruiter create(@RequestBody Recruiter recruiter){
        return recruiterService.create(recruiter);
    }

    @PutMapping("/update")
    public Recruiter update(@RequestBody Recruiter recruiter){
        return recruiterService.update(recruiter);
    }

    @DeleteMapping("/delete/{id}")
    public Recruiter deleteById(@PathVariable("id") long id){
        return recruiterService.deleteById(id);
    }
}
