package com.zidioconnect.code.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="certification")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="vendor")
    private String vendor;

    @Column(name="date_achieved")
    private Date dateAchieved;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getDateAchieved() {
        return dateAchieved;
    }

    public void setDateAchieved(Date dateAchieved) {
        this.dateAchieved = dateAchieved;
    }

//    Dont include this
//    public Student getStudent() {
//        return student;
//    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", vendor='" + vendor + '\'' +
                ", dateAchieved=" + dateAchieved +
                '}';
    }
}
