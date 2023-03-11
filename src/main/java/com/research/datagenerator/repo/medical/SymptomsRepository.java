package com.research.datagenerator.repo.medical;

import com.research.datagenerator.entity.medical.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomsRepository extends JpaRepository<Symptoms, Long> {
}