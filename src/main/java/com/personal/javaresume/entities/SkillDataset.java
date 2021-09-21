package com.personal.javaresume.entities;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class SkillDataset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(example = "Angular", defaultValue = "Angular", required = true)
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Please enter key skill")
    private String name;


    public String getSkillName() {
        return name;
    }

    public void setSkillName(String skillName) {
        this.name = skillName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
