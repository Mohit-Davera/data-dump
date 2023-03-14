package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {
}