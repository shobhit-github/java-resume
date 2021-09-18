package com.personal.javaresume.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(example = "MCA", defaultValue = "MCA", required = true)
    @Column(nullable = false)
    @NotBlank(message = "Please enter your course name")
    private String course;

    @Schema(example = "demo description", defaultValue = "demo description")
    @Lob
    private String description;

    @Schema(example = "Hayward University", defaultValue = "Hayward University")
    @Column(nullable = false)
    @NotBlank(message = "Please enter your institute name")
    private String institute;

    @Schema(example = "2020-05-06", defaultValue = "2020-05-06")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date start;

    @Schema(example = "2020-05-06", defaultValue = "2020-05-06")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date end;

    @Schema(example = "true", defaultValue = "true")
    @Column(columnDefinition = "BOOLEAN default TRUE")
    private Boolean status;


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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
