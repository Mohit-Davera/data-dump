package com.research.datagenerator.repo.currency;

import com.research.datagenerator.entity.currency.CurrencyName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyNameRepository extends JpaRepository<CurrencyName, Long> {
}