package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.CityName;
import com.research.datagenerator.entity.address.CitySuffix;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitySuffixRepository extends JpaRepository<CitySuffix, Long> {
}