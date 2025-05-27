package com.zidioconnect.code.services;

import com.zidioconnect.code.models.Application;

import java.util.List;

public interface IApplicationService {
    List<Application> getAll();
    Application createApplication(Application application);
    List<Application> getApplicationsByStudent(long studentId);
    List<Application> getApplicationsByJob(long jobId);
    Application deleteById(long id);
    Application update(Application application);
}
