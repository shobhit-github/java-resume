package com.personal.javaresume.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(example = "Software Developer", defaultValue = "Software Developer", required = true)
    @Column(nullable = false)
    @NotBlank(message = "Please enter your role / profile for this company")
    private String profile;

    @Schema(example = "demo-description", defaultValue = "demo-description", required = true)
    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Please enter job description")
    private String job_description;

    @Schema(example = "2020-05-06", defaultValue = "2020-05-06", required = true)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "Please enter start date")
    private Date joinedAt;

    @Schema(example = "2020-05-06", defaultValue = "2020-05-06")
    @Temporal(TemporalType.DATE)
    @Column()
    private Date resignedAt;

    @Schema(example = "XYZ Company", defaultValue = "XYZ Company", required = true)
    @Column(nullable = false)
    @NotBlank(message = "Please enter company name")
    private String companyName;

    @Schema(example = "false", defaultValue = "false")
    @Column(columnDefinition = "BOOLEAN default FALSE")
    private Boolean stillWorking;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Boolean getStillWorking() {
        return stillWorking;
    }

    public void setStillWorking(Boolean stillWorking) {
        this.stillWorking = stillWorking;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getEnd() {
        return resignedAt;
    }

    public void setEnd(Date end) {
        this.resignedAt = end;
    }

    public Date getStart() {
        return joinedAt;
    }

    public void setStart(Date start) {
        this.joinedAt = start;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
