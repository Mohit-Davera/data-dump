package com.research.datagenerator.repo.businessRepository;

import com.research.datagenerator.entity.Business.CreditCardExpiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardExpiryRepository extends JpaRepository<CreditCardExpiry,Long> {
}
