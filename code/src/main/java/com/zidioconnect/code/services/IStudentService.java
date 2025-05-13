package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();
    Student getUserById(long id);
    Student create(Student student);
    Student update(Student student);
    Student deleteUserById(long id);

}
