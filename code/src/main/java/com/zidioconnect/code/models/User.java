package com.zidioconnect.code.models;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    public enum Role {
        STUDENT, RECRUITER, ADMIN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // Constructor with initialization
    public User() {
        this.id = 0L;
        this.email = null;
        this.password = null;
        this.role = null;
    }

    public long getId() {
        return id;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id+
                ", email='" + email + '\'' +
                ", password='[PROTECTED]'" +  // Never expose passwords in logs
                ", role=" + (role != null ? role.name() : "null") +
                '}';
    }
}


