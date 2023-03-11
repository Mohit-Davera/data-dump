package com.research.datagenerator.repo.nation;

import com.research.datagenerator.entity.nation.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}