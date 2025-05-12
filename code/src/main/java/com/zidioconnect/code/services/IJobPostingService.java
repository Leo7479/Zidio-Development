package com.zidioconnect.code.services;

import com.zidioconnect.code.models.JobPosting;

import java.util.List;

public interface IJobPostingService {
    List<JobPosting> getAll();
    JobPosting getById(long id);
    List<JobPosting> getByName(String name);
    JobPosting getByDescription(String description);
    JobPosting create(JobPosting jobPosting);
    JobPosting deleteById(long id);
    JobPosting update(JobPosting jobPosting);
}
