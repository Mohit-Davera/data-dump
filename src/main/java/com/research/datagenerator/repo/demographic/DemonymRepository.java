package com.research.datagenerator.repo.demographic;

import com.research.datagenerator.entity.demographic.Demonym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemonymRepository extends JpaRepository<Demonym, Long> {
}