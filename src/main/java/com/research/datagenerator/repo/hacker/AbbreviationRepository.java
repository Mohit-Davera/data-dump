package com.research.datagenerator.repo.hacker;

import com.research.datagenerator.entity.hacker.Abbreviation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbbreviationRepository extends JpaRepository<Abbreviation, Long> {
}