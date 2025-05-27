package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Certification;
import com.zidioconnect.code.repositories.ICertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService implements ICertificationService{
    private final ICertificationRepository certificationRepository;

    @Autowired
    public CertificationService(ICertificationRepository certificationRepository){
        this.certificationRepository = certificationRepository;
    }


    @Override
    public List<Certification> getAll() {
        return certificationRepository.findAll();
    }

    @Override
    public List<Certification> getByStudent(long id) {
        return certificationRepository.findByStudent_Id(id);
    }

    @Override
    public Certification getById(long id) {
        Optional<Certification> certification = certificationRepository.findById(id);
        return certification.orElse(null);
    }

    @Override
    public Certification create(Certification certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public Certification deleteById(long id) {
        Certification certification = getById(id);
        certificationRepository.deleteById(id);
        return certification;
    }

    @Override
    public Certification update(Certification certification) {
        return certificationRepository.save(certification);
    }
}
