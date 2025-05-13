package com.zidioconnect.code.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidioconnect.code.models.Application;
import com.zidioconnect.code.models.JobPosting;
import com.zidioconnect.code.models.Student;
import com.zidioconnect.code.repositories.IApplicationRepository;
import com.zidioconnect.code.repositories.IJobPostingRepository;
import com.zidioconnect.code.repositories.IStudentRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Student> student = studentRepository.findById(studentId);
        return student.map(applicationRepository::findByStudent).orElse(null);
    }

    @Override
    public List<Application> getApplicationsByJob(long jobId) {
        Optional<JobPosting> jobPosting = jobPostingRepository.findById(jobId);
        return jobPosting.map(applicationRepository::findByJobPosting).orElse(null);
    }
}
