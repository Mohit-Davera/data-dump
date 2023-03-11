package com.research.datagenerator.repo.programming;

import com.research.datagenerator.entity.programming.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}