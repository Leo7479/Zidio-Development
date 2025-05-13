package com.zidioconnect.code.models;

import jakarta.persistence.*;

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
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "status")
    private String status;  // e.g., "applied", "reviewed", "rejected"

    public Application() {}

    public Application(JobPosting jobPosting, Student student, String status) {
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

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", jobPosting=" + jobPosting.getId() +
                ", student=" + student.getId() +
                ", status='" + status + '\'' +
                '}';
    }
}
