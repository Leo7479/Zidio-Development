package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Student;
import com.zidioconnect.code.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    @Override
    public Student getUserById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {

        if (studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public Student deleteUserById(long id) {
        Student student = getUserById(id);
        if (student != null) {
            studentRepository.deleteById(id);
        }
        return student;
    }

}
