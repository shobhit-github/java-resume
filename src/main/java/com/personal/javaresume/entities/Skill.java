package com.personal.javaresume.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(required = true, defaultValue = "80")
    @Column(nullable = false)
    @NotNull(message = "Please enter rating of your skill")
    private Integer rating;

    @Schema(required = true, defaultValue = "true")
    @Column(nullable = false, columnDefinition = "BOOLEAN default TRUE")
    private Boolean status = false;

    @ManyToOne
    @JoinColumn()
    private Profession profession;

    @OneToOne(orphanRemoval = true)
    @JoinColumn
    private SkillDataset skill;

    public SkillDataset getSkill() {
        return skill;
    }

    public void setSkill(SkillDataset skill) {
        this.skill = skill;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
