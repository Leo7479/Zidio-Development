package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Recruiter;
import com.zidioconnect.code.repositories.IRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService implements IRecruiterService {
    private final IRecruiterRepository recruiterRepo;
    @Autowired
    public RecruiterService(IRecruiterRepository recruiterRepo){
        this.recruiterRepo = recruiterRepo;
    }

    @Override
    public List<Recruiter> getAll() {
        return recruiterRepo.findAll();
    }

    @Override
    public Recruiter getById(long id) {
        Optional<Recruiter> recruiter = recruiterRepo.findById(id);
        if(recruiter.isPresent()){
            return recruiter.get();
        }else{
            return null;
        }
    }

    @Override
    public Recruiter getByUser_Id(long user_id){
        Optional<Recruiter> recruiter = recruiterRepo.findByUser_Id(user_id);
        if(recruiter.isPresent()) {
            return recruiter.get();
        }else{
            return null;
        }
    }

    @Override
    public List<Recruiter> getByName(String name) {
        return recruiterRepo.findByCompanyName(name);
    }

    @Override
    public Recruiter create(Recruiter recruiter) {
        return recruiterRepo.save(recruiter);
    }

    @Override
    public Recruiter update(Recruiter recruiter) {
        return recruiterRepo.save(recruiter);
    }

    @Override
    public Recruiter deleteById(long id) {
        Recruiter recruiter = this.getById(id);
        recruiterRepo.deleteById(id);
        return recruiter;
    }
}
