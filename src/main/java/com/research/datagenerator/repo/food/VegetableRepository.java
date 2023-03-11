package com.research.datagenerator.repo.food;

import com.research.datagenerator.entity.food.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
}