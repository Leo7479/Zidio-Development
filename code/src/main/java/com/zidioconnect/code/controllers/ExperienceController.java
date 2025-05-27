package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.Experience;
import com.zidioconnect.code.services.ExperienceService;
import com.zidioconnect.code.services.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    private final IExperienceService experienceService;

    @Autowired
    public ExperienceController(IExperienceService experienceService){
        this.experienceService = experienceService;
    }

    @GetMapping
    public List<Experience> getAll(){
        return experienceService.getAll();
    }
    @GetMapping("/student/{id}")
    public List<Experience> getByStudent(@PathVariable long id){
        return experienceService.getByStudent(id);
    }
    @GetMapping("/{id}")
    public Experience getById(@PathVariable long id){
        return experienceService.getById(id);
    }

    @PostMapping("/create")
    public Experience create(@RequestBody Experience experience){
        return experienceService.create(experience);
    }

    @DeleteMapping("/delete/{id}")
    public Experience deleteById(@PathVariable long id){
        return experienceService.deleteById(id);
    }

    @PutMapping("/update")
    public Experience update(@RequestBody Experience experience){
        return experienceService.update(experience);
    }
}
