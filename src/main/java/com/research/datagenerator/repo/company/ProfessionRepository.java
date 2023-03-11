package com.research.datagenerator.repo.company;

import com.research.datagenerator.entity.company.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}