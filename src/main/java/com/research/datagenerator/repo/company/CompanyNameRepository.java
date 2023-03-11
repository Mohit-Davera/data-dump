package com.research.datagenerator.repo.company;

import com.research.datagenerator.entity.company.CompanyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyNameRepository extends JpaRepository<CompanyName,Long> {
}
