package com.zidioconnect.code.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Recruiter")
public class Recruiter {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary Key for Recruiter Entity

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @Column(name="company_name")
    private String companyName;

    @Column(name="company_email")
    private String companyEmail;

    // Constructors
    public Recruiter(){
        this.id = 0;
        this.user = null;
        this.companyName = null;
        this.companyEmail = null;
    }
    public Recruiter(User user, String companyName, String companyEmail){
        super();
        this.user = user;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
    }

    // Getters and Setters
    public long getId(){
        return this.id;
    }
    public User getUser(){
        return this.user;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getCompanyEmail(){
        return companyEmail;
    }
    public void setUser(User user){
        this.user = user;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public void setCompanyEmail(String companyEmail){
        this.companyEmail = companyEmail;
    }


    // toString method
    @Override
    public String toString() {
        return "Recruiter{" +
                "id=" + id +
                ", user=" + user +
                ", companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                '}';
    }
}
