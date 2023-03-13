package com.research.datagenerator.repo.businessRepository;

import com.research.datagenerator.entity.Business.CreditCardExpiry;
import com.research.datagenerator.entity.Business.CreditCardNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardNumberRepository  extends JpaRepository<CreditCardNumber,Long> {
}
