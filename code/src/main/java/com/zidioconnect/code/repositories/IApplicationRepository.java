package com.zidioconnect.code.repositories;

import com.zidioconnect.code.models.Application;
import com.zidioconnect.code.models.Student;
import com.zidioconnect.code.models.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByStudent(Student student);
    List<Application> findByJobPosting(JobPosting jobPosting);
}
