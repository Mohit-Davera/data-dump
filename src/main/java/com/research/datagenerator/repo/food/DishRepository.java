package com.research.datagenerator.repo.food;

import com.research.datagenerator.entity.food.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}