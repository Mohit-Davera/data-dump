package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.ZipCodeByState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipCodeByStateRepository extends JpaRepository<ZipCodeByState, Long> {
}