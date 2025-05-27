package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Certification;

import java.util.List;

public interface ICertificationService {
    List<Certification> getAll();
    List<Certification> getByStudent(long id);
    Certification getById(long id);
    Certification create(Certification certification);
    Certification deleteById(long id);
    Certification update(Certification certification);
}
