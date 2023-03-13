package com.research.datagenerator.repo.businessRepository;

import com.research.datagenerator.entity.Business.BusinessCreditCardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardTypeRepository  extends JpaRepository<BusinessCreditCardType,Long> {
}
