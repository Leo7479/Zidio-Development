package com.zidioconnect.code.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidioconnect.code.models.Application;
import com.zidioconnect.code.repositories.IApplicationRepository;
import com.zidioconnect.code.repositories.IJobPostingRepository;
import com.zidioconnect.code.repositories.IStudentRepository;

import java.util.List;

@Service
public class ApplicationService implements IApplicationService {

    private final IApplicationRepository applicationRepository;
    private final IStudentRepository studentRepository;
    private final IJobPostingRepository jobPostingRepository;

    @Autowired
    public ApplicationService(IApplicationRepository applicationRepository,
                              IStudentRepository studentRepository,
                              IJobPostingRepository jobPostingRepository) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.jobPostingRepository = jobPostingRepository;
    }

    @Override
    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplicationsByStudent(long studentId) {
        // Directly use the ID-based method instead of fetching the full student
        return applicationRepository.findByStudent_Id(studentId);
    }

    @Override
    public List<Application> getApplicationsByJob(long jobId) {
        // Directly use the ID-based method instead of fetching the full job posting
        return applicationRepository.findByJobPosting_Id(jobId);
    }
}
