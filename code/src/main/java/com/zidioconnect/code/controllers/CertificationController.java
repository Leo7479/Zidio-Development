package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.Certification;
import com.zidioconnect.code.services.CertificationService;
import com.zidioconnect.code.services.ICertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certification")
public class CertificationController {

    private final ICertificationService CertificationService;

    @Autowired
    public CertificationController(ICertificationService CertificationService){
        this.CertificationService = CertificationService;
    }

    @GetMapping
    public List<Certification> getAll(){
        return CertificationService.getAll();
    }
    @GetMapping("/student/{id}")
    public List<Certification> getByStudent(@PathVariable long id){
        return CertificationService.getByStudent(id);
    }
    @GetMapping("/{id}")
    public Certification getById(@PathVariable long id){
        return CertificationService.getById(id);
    }

    @PostMapping("/create")
    public Certification create(@RequestBody Certification Certification){
        return CertificationService.create(Certification);
    }

    @DeleteMapping("/delete/{id}")
    public Certification deleteById(@PathVariable long id){
        return CertificationService.deleteById(id);
    }

    @PutMapping("/update")
    public Certification update(@RequestBody Certification Certification){
        return CertificationService.update(Certification);
    }
}
