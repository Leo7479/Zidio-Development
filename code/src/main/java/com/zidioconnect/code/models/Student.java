package com.zidioconnect.code.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "resume_link")
    private String resumeLink;

    @Column(name="skills")
    private String skills;

    @OneToMany(mappedBy = "student")
    private List<Application> applications;

    // Constructor with initialization
    public Student() {
        this.user = null;
        this.resumeLink = null;
        this.skills = null;
        this.applications = null;
    }

    public Student(User user, String resumeLink, String skills, List<Application> applications) {
        super();
        this.user = user;
        this.resumeLink = resumeLink;
        this.skills = skills;
        this.applications = applications;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getResumeLink() {
        return resumeLink;
    }
    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public List<Application> getApplications(){ return this.applications;}
    public void setApplications(List<Application> applications) { this.applications = applications;}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id+
                ", user=" + (user != null ? "user" : "null") +
                ", resumeLink='" + resumeLink + '\'' +
                ", skills='" + skills + '\'' +
                ", Applications= '"+applications + "'" +
                '}';
    }

}



