package com.research.datagenerator.repo.food;

import com.research.datagenerator.entity.food.Sushi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SushiRepository extends JpaRepository<Sushi, Long> {
}