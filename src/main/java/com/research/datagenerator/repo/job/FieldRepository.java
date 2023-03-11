package com.research.datagenerator.repo.job;

import com.research.datagenerator.entity.job.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long> {
}