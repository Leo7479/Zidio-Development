package com.zidioconnect.code.controllers;

import com.zidioconnect.code.models.Student;
import com.zidioconnect.code.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final IStudentService studentService;
    @Autowired
    public StudentController(IStudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        try{
            return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentService.create(student), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id){
        try{
            return new ResponseEntity<>(studentService.getUserById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student){
        try{
            return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable long id){
        try{
            return new ResponseEntity<>(studentService.deleteUserById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
