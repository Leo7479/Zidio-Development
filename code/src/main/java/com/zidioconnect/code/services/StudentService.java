package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Student;
import com.zidioconnect.code.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}
