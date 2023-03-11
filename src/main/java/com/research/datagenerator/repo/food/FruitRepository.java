package com.research.datagenerator.repo.food;

import com.research.datagenerator.entity.food.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
}