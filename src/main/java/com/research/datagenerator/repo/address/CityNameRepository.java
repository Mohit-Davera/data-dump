package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.BuildingNumber;
import com.research.datagenerator.entity.address.CityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityNameRepository extends JpaRepository<CityName, Long> {
}