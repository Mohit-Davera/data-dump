package com.research.datagenerator.repo.hacker;

import com.research.datagenerator.entity.hacker.Verb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerbRepository extends JpaRepository<Verb, Long> {
}