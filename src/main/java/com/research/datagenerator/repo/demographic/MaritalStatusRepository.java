package com.research.datagenerator.repo.demographic;

import com.research.datagenerator.entity.demographic.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Long> {
}