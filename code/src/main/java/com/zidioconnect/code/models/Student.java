package com.zidioconnect.code.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student")
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

    @Column(name="education")
    private String education;

    @Column(name="year_of_passing")
    private int yearOfPassing;

    @OneToMany(mappedBy = "student")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "student")
    private List<Certification> certifications;


    // Constructor with initialization
    public Student() {
        this.user = null;
        this.resumeLink = null;
        this.skills = null;
        this.certifications = null;
        this.education = null;
        this.yearOfPassing = 0;
    }

    public Student(User user, String resumeLink, String skills, String education, int yearOfPassing, List<Certification> certifications, List<Experience> experiences) {
        super();
        this.user = user;
        this.resumeLink = resumeLink;
        this.skills = skills;
        this.education = education;
        this.yearOfPassing = yearOfPassing;
        this.certifications = certifications;
        this.experiences = experiences;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", user=" + user +
                ", resumeLink='" + resumeLink + '\'' +
                ", skills='" + skills + '\'' +
                ", education='" + education + '\'' +
                ", yearOfPassing=" + yearOfPassing +
                ", certifications=" + certifications +
                ", experiences=" + experiences +
                '}';
    }
}



