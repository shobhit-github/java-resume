package com.personal.javaresume.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(example = "Demo Description", defaultValue = "Demo Description", required = true)
    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Please enter summary details")
    private String summary;

    @Schema(required = true, defaultValue = "Software Engineer", example = "Software Engineer")
    @Column(nullable = false)
    @NotBlank(message = "Please enter your job title, eg: (Software Developer, Accountant)")
    private String jobTitle;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(nullable = false)
    private Personal personal;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Personal getPersonalDetail() {
        return personal;
    }

    public void setPersonalDetail(Personal personal) {
        this.personal = personal;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
