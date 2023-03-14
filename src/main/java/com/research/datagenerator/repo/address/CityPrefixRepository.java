package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.CityPrefix;
import com.research.datagenerator.entity.address.CitySuffix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityPrefixRepository extends JpaRepository<CityPrefix, Long> {
}