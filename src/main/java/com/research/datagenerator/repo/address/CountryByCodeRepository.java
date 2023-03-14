package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.CountryByCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryByCodeRepository extends JpaRepository<CountryByCode, Long> {
}