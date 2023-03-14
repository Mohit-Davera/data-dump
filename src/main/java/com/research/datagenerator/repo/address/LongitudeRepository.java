package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.Latitude;
import com.research.datagenerator.entity.address.Longitude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LongitudeRepository extends JpaRepository<Longitude, Long> {
}