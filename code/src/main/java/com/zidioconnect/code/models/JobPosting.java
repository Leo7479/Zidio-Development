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

    @Column(name="salary")
    private long salary;

    @Column(name="skills_required")
    private String skillsRequired;

    @Column(name="years_of_experience")
    private int yearsOfExperience;


    // Constructors
    public JobPosting(){
        this.id=0;
        this.title=null;
        this.description=null;
        this.recruiter=null;
        this.salary = 0L;
    }
    public JobPosting(String title, String description, Recruiter recruiter, long salary, String skillsRequired){
        super();
        this.title=title;
        this.description=description;
        this.recruiter=recruiter;
        this.salary = salary;
        this.skillsRequired = skillsRequired;
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getSkillsRequired() {
        return skillsRequired;
    }

    public void setSkillsRequired(String skillsRequired) {
        this.skillsRequired = skillsRequired;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    // toString


    @Override
    public String toString() {
        return "JobPosting{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", recruiter=" + recruiter +
                ", salary=" + salary +
                ", skillsRequired='" + skillsRequired + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}
