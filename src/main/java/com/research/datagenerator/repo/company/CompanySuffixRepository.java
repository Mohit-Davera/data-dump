package com.research.datagenerator.repo.company;

import com.research.datagenerator.entity.company.CompanySuffix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanySuffixRepository extends JpaRepository<CompanySuffix,Long> {
}
