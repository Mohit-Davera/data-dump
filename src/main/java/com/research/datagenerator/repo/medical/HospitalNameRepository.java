package com.research.datagenerator.repo.medical;

import com.research.datagenerator.entity.medical.HospitalName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalNameRepository extends JpaRepository<HospitalName, Long> {
}