package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.BuildingNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingNumberRepository extends JpaRepository<BuildingNumber, Long> {
}