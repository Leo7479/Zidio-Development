package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Experience;
import com.zidioconnect.code.repositories.IExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService implements IExperienceService{

    private final IExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(IExperienceRepository experienceRepository){
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    @Override
    public List<Experience> getByStudent(long id) {
        return experienceRepository.findByStudent_Id(id);
    }

    @Override
    public Experience getById(long id) {
        Optional<Experience> experience = experienceRepository.findById(id);
        return experience.orElse(null);
    }

    @Override
    public Experience create(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience deleteById(long id) {
        Experience experience = this.getById(id);
        experienceRepository.deleteById(id);
        return experience;
    }

    @Override
    public Experience update(Experience experience) {
        return experienceRepository.save(experience);
    }

}
