package com.personal.javaresume.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class PortfolioSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Portfolio portfolio;

    @OneToOne(orphanRemoval = true)
    @JoinColumn()
    private SkillDataset skillDataset;

    public SkillDataset getSkillDataset() {
        return skillDataset;
    }

    public void setSkillDataset(SkillDataset skillDataset) {
        this.skillDataset = skillDataset;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
