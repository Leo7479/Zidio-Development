package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Recruiter;

import java.util.List;

public interface IRecruiterService {
    List<Recruiter> getAll();
    Recruiter getById(long id);
    Recruiter getByUser_Id(long user_id);
    List<Recruiter> getByName(String name);
    Recruiter create(Recruiter recruiter);
    Recruiter update(Recruiter recruiter);
    Recruiter deleteById(long id);
}
