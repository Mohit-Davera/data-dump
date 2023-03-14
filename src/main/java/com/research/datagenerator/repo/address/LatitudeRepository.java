package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.FullAddress;
import com.research.datagenerator.entity.address.Latitude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LatitudeRepository extends JpaRepository<Latitude, Long> {
}