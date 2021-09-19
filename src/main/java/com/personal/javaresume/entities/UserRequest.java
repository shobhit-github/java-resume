package com.personal.javaresume.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(defaultValue = "Ankit Gupta", required = true)
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Please enter your name")
    private String fullName;

    @Schema(defaultValue = "sh@email.com", required = true)
    @Column(nullable = false, length = 100)
    @NotBlank(message = "Please enter your email id")
    @Email(message = "Please enter valid email id")
    private String email;

    @Schema(defaultValue = "Sample Message Subject", required = true)
    @Column(nullable = false)
    @NotBlank(message = "Please enter subject")
    private String subject;

    @Schema(defaultValue = "Sample Message", required = true)
    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Please enter message of this email")
    private String message;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @ManyToOne
    @JoinColumn()
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
