package com.zidioconnect.code.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="job_posts")
public class JobPosting {
    // Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="recruiter_id")
    private Recruiter recruiter;

    @OneToMany(mappedBy = "jobPosting")
    private List<Application> applications;

    // Constructors
    public JobPosting(){
        this.id=0;
        this.title=null;
        this.description=null;
        this.recruiter=null;
        this.applications = null;
    }
    public JobPosting(String title, String description, Recruiter recruiter, List<Application> applications){
        super();
        this.title=title;
        this.description=description;
        this.recruiter=recruiter;
        this.applications = applications;
    }
    // Getters and Setters

    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Recruiter getRecruiter() {
        return recruiter;
    }
    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
// toString


    @Override
    public String toString() {
        return "JobPosting{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", recruiter=" + recruiter +
                ", applications=" + applications +
                '}';
    }
}
