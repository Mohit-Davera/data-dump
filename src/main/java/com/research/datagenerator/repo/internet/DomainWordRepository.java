package com.research.datagenerator.repo.internet;

import com.research.datagenerator.entity.internet.DomainWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainWordRepository extends JpaRepository<DomainWord, Long> {
}