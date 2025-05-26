package com.zidioconnect.code.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "applications")
public class Application {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobPosting jobPosting;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    @Column(name = "status")
    private Status status;

    public Application() {
        this.id = 0L;
        this.jobPosting = null;
        this.student = null;
        this.status = null;
    }

    public Application(JobPosting jobPosting, Student student, Status status) {
        this.jobPosting = jobPosting;
        this.student = student;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student students) {
        this.student = students;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", jobPosting=" + (jobPosting != null ? jobPosting.getId() : "null") +
                ", student=" + (student != null ? student : "null") +
                ", status='" + status + '\'' +
                '}';
    }
}
