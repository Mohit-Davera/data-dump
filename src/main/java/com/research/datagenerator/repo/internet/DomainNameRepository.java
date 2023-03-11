package com.research.datagenerator.repo.internet;

import com.research.datagenerator.entity.internet.DomainName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainNameRepository extends JpaRepository<DomainName, Long> {
}