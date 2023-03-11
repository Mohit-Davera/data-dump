package com.research.datagenerator.repo.food;

import com.research.datagenerator.entity.food.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}