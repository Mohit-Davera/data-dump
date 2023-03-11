package com.research.datagenerator.repo.food;

import com.research.datagenerator.entity.food.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepository extends JpaRepository<Description, Long> {
}