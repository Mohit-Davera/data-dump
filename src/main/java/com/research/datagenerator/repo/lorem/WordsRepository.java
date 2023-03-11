package com.research.datagenerator.repo.lorem;

import com.research.datagenerator.entity.lorem.Words;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepository extends JpaRepository<Words, Long> {
}