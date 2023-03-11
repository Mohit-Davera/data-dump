package com.research.datagenerator.repo.demographic;

import com.research.datagenerator.entity.demographic.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexRepository extends JpaRepository<Sex, Long> {
}