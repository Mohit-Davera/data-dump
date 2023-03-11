package com.research.datagenerator.repo.weather;

import com.research.datagenerator.entity.weather.TemperatureCelsius;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureCelsiusRepository extends JpaRepository<TemperatureCelsius, Long> {
}