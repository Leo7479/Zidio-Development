package com.zidioconnect.code.services;

import com.zidioconnect.code.models.JobPosting;
import com.zidioconnect.code.repositories.IJobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPostingService implements IJobPostingService{
    private final IJobPostingRepository jobPostingRepo;

    @Autowired
    public JobPostingService(IJobPostingRepository jobPostingRepo){
        this.jobPostingRepo = jobPostingRepo;
    }

    @Override
    public List<JobPosting> getAll() {
        return jobPostingRepo.findAll();
    }
    @Override
    public JobPosting getById(long id) {
        Optional<JobPosting> jobPosting = jobPostingRepo.findById(id);
        if(jobPosting.isPresent()){
            return jobPosting.get();
        }else{
            return null;
        }
    }

    @Override
    public List<JobPosting> getByName(String name) {
        return jobPostingRepo.findByName(name);
    }

    @Override
    public JobPosting getByDescription(String description) {
        return null;
    }

    @Override
    public JobPosting create(JobPosting jobPosting) {
        return jobPostingRepo.save(jobPosting);
    }

    @Override
    public JobPosting deleteById(long id) {
        JobPosting jobPosting = this.getById(id);
        jobPostingRepo.deleteById(id);
        return jobPosting;
    }

    @Override
    public JobPosting update(JobPosting jobPosting) {
        return jobPostingRepo.save(jobPosting);
    }
}
