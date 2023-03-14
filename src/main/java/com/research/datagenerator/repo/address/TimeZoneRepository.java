package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.StreetSuffix;
import com.research.datagenerator.entity.address.TimeZone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeZoneRepository extends JpaRepository<TimeZone, Long> {
}