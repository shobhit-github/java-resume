package com.personal.javaresume.dao;

import com.personal.javaresume.entities.Personal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonalDetailRepository extends JpaRepository<Personal, Long> {

    boolean existsByWebsite(String domain);

    boolean existsByEmail(String email);

    boolean existsByUsername(String domain);

    boolean existsByPhone(String email);

    Personal findByEmail(String email);
}
