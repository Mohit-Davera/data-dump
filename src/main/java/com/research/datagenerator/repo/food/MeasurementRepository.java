package com.research.datagenerator.repo.food;

import com.research.datagenerator.entity.food.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}