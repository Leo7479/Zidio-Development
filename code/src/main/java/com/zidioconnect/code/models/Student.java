package com.zidioconnect.code.models;
import jakarta.persistence.*;

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

    @Column
    private String skills;

    // Constructor with initialization
    public Student() {
        this.id = 0L;
        this.user = null;
        this.resumeLink = null;
        this.skills = null;
    }

    // Getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getResumeLink() { return resumeLink; }
    public void setResumeLink(String resumeLink) { this.resumeLink = resumeLink; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
}



