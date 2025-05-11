package com.zidioconnect.code.models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "resume_link")
    private String resumeLink;

    @Column
    private String skills; // Could also be @ElementCollection for multiple skills

    // Constructors
    public Student() {}

    public Student(User user, String resumeLink, String skills) {
        this.user = user;
        this.resumeLink = resumeLink;
        this.skills = skills;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // toString() (optional)
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", user=" + user +
                ", resumeLink='" + resumeLink + '\'' +
                ", skills='" + skills + '\'' +
                '}';
    }
}
