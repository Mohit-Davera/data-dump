package com.research.datagenerator.repo.medical;

import com.research.datagenerator.entity.medical.DiseaseName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseNameRepository extends JpaRepository<DiseaseName, Long> {
}