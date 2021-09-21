package com.personal.javaresume.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(example = "Project 1", defaultValue = "Project 1", required = true)
    @Column(nullable = false)
    @NotBlank(message = "Please enter project name")
    private String projectName;

    @Schema(example = "Healthcare", defaultValue = "Healthcare")
    @Column()
    private String businessDomain;

    @Schema(defaultValue = "Tom Jard")
    @Column(columnDefinition = "VARCHAR(50) default 'Confidential'", nullable = false)
    private String client;

    @Schema(example = "demo-project-description", defaultValue = "demo-project-description")
    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Please enter project description")
    private String description;

    @Schema(example = "2020-06-05", defaultValue = "2020-06-05", required = true)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "Please enter when project has started")
    private Date startDate;

    @Schema(example = "2020-06-05", defaultValue = "2020-06-05")
    @Temporal(TemporalType.DATE)
    @Column()
    private Date endDate;

    @Schema(example = "Peter Hammond", defaultValue = "Peter Hammond")
    @Column(length = 50)
    private String projectManager;

    @Schema(example = "2", defaultValue = "2", required = true)
    @Column(nullable = false, columnDefinition = "INTEGER default 1")
    private Integer teamSize;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @OneToMany(mappedBy = "portfolio", orphanRemoval = true)
    private List<PortfolioImage> portfolioImages;

    @Schema(defaultValue = "true", required = true)
    @Column(nullable = false, columnDefinition = "BOOLEAN default TRUE")
    private Boolean status = false;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioSkill> portfolioSkills;

    public List<PortfolioSkill> getPortfolioSkills() {
        return portfolioSkills;
    }

    public void setPortfolioSkills(List<PortfolioSkill> portfolioSkills) {
        this.portfolioSkills = portfolioSkills;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<PortfolioImage> getPortfolioImages() {
        return portfolioImages;
    }

    public void setPortfolioImages(List<PortfolioImage> portfolioImages) {
        this.portfolioImages = portfolioImages;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBusinessDomain() {
        return businessDomain;
    }

    public void setBusinessDomain(String businessDomain) {
        this.businessDomain = businessDomain;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
