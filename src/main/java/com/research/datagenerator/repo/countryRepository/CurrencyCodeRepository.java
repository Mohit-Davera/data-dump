package com.research.datagenerator.repo.countryRepository;

import com.research.datagenerator.entity.Country.CurrencyCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyCodeRepository extends JpaRepository<CurrencyCode,Long> {
}
