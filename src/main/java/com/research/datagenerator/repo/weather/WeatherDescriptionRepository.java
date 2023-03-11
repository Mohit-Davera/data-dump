package com.research.datagenerator.repo.weather;

import com.research.datagenerator.entity.weather.WeatherDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDescriptionRepository extends JpaRepository<WeatherDescription, Long> {
}