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
        // Check if the Student and JobPosting exist using findBy methods
        Optional<Student> student = studentRepository.findById(application.getStudent().getId());
        Optional<JobPosting> jobPosting = jobPostingRepository.findById(application.getJobPosting().getId());

        // Only create and save the application if both entities are valid
        if (student.isPresent() && jobPosting.isPresent()) {
            // Set the student and job posting fetched from DB
            application.setStudent(student.get());
            application.setJobPosting(jobPosting.get());
            return applicationRepository.save(application);
        } else {
            throw new IllegalArgumentException("Student or JobPosting not found");
        }
    }

    @Override
    public List<Application> getApplicationsByStudent(long studentId) {
        return applicationRepository.findByStudent_Id(studentId);
    }

    @Override
    public List<Application> getApplicationsByJob(long jobId) {
        return applicationRepository.findByJobPosting_Id(jobId);
    }

    @Override
    public Application deleteById(long id){
        Optional<Application> application= applicationRepository.findById(id);
        return application.orElse(null);
    }

    @Override
    public Application update(Application application){
        return applicationRepository.save(application);
    }
}
