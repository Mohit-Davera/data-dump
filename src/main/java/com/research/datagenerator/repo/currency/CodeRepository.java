package com.research.datagenerator.repo.currency;

import com.research.datagenerator.entity.currency.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code, Long> {
}