package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.CityName;
import com.research.datagenerator.entity.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}