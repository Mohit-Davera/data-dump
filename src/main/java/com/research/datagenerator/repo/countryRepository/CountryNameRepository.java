package com.research.datagenerator.repo.countryRepository;

import com.research.datagenerator.entity.Country.CountryName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryNameRepository extends JpaRepository<CountryName,Long> {
}
