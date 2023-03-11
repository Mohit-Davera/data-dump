package com.research.datagenerator.repo.job;

import com.research.datagenerator.entity.job.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTypeRepository extends JpaRepository<EmploymentType, Long> {
}