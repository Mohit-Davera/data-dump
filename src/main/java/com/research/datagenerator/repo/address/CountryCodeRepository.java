package com.research.datagenerator.repo.address;

import com.research.datagenerator.entity.address.Country;
import com.research.datagenerator.entity.address.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCodeRepository extends JpaRepository<CountryCode, Long> {
}