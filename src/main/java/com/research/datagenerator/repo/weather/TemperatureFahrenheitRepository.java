package com.research.datagenerator.repo.weather;

import com.research.datagenerator.entity.weather.TemperatureFahrenheit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureFahrenheitRepository extends JpaRepository<TemperatureFahrenheit, Long> {
}