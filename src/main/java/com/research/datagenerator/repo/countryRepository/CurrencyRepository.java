package com.research.datagenerator.repo.countryRepository;

import com.research.datagenerator.entity.Country.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository  extends JpaRepository<Currency,Long> {
}
