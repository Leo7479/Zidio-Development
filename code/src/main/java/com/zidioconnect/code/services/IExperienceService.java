package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Experience;

import java.util.List;

public interface IExperienceService {
    List<Experience> getAll();
    List<Experience> getByStudent(long id);
    Experience getById(long id);
    Experience create(Experience experience);
    Experience deleteById(long id);
    Experience update(Experience experience);
}
