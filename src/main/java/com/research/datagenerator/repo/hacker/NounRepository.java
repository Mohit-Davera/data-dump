package com.research.datagenerator.repo.hacker;

import com.research.datagenerator.entity.hacker.Noun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NounRepository extends JpaRepository<Noun, Long> {
}