package com.research.datagenerator.repo.countryRepository;

import com.research.datagenerator.entity.Country.Capital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapitalRepository extends JpaRepository<Capital,Long> {
}
